interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;
    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }
    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }
    private void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }
    @Override
    public void send(String message) {
        super.send(message);
        sendSlack(message);
    }
    private void sendSlack(String message) {
        System.out.println("Sending Slack message: " + message);
    }
}

public class DecoratorPatternExample {
    public static void main(String[] args) {      
        Notifier emailNotifier = new EmailNotifier();
        Notifier emailAndSMSNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier emailSMSAndSlackNotifier = new SlackNotifierDecorator(emailAndSMSNotifier);
        emailSMSAndSlackNotifier.send("This is notifiaction 1");
        emailAndSMSNotifier.send("This is notification 2");
    }
}

// OUTPUT
// Sending email: This is notifiaction 1
// Sending SMS: This is notifiaction 1
// Sending Slack message: This is notifiaction 1
// Sending email: This is notification 2
// Sending SMS: This is notification 2