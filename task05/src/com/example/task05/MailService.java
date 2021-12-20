package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<MailParcel<T>> {

    private final Map<String, List<T>> mailbox = new HashMap<String, List<T>>() {
        @Override
        public List<T> get(Object key) {
            List<T> result = super.get(key);
            return result != null ? result : Collections.emptyList();
        }
    };

    @Override
    public void accept(MailParcel<T> mailParcel) {
        if (mailbox.containsKey(mailParcel.getTo()))
            mailbox.get(mailParcel.getTo()).add(mailParcel.getContent());
        else
            mailbox.put(mailParcel.getTo(), new ArrayList<>(Collections.singletonList(mailParcel.getContent())));
    }

    public Map<String, List<T>> getMailBox() {
        return mailbox;
    }
}