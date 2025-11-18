package io.github.credit.insight.api.domain.exception;


import io.github.credit.insight.api.domain.validation.handler.Notification;

public class NotificationException extends DomainException {

    public NotificationException(final String aMessage, final Notification notification) {
        super(aMessage, notification.getErrors());
    }

}
