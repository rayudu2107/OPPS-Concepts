package has_arelation;

class Attachment {
    String name;
    double size;
    String type;

    public Attachment(String name, double size, String type) {
        this.name = name;
        this.size = size;
        this.type = type;
    }

    public void showDetails() {
        System.out.println("Attachment name: " + name);
        System.out.println("File Size: " + size + " Kb");
        System.out.println("File Type: " + type);
    }
}

class Email {
    String sender;
    String subject;
    String msg;
    Attachment attachment; // Declare attachment here

    public Email(String sender, String subject, String msg, Attachment attachment) {
        this.sender = sender;
        this.subject = subject;
        this.msg = msg;
        this.attachment = attachment; // Assign attachment here
    }

    public void openMail() {
        System.out.println("Sender: " + sender);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + msg);
        if (attachment != null) {
            attachment.showDetails(); 
        }
    }
}

public class Composition {
    public static void main(String[] args) {
        Attachment attachment = new Attachment("file1", 2.5, "txt");
        Email email = new Email("Pradeepkumer2107@gmail.com", "java", "notes", attachment);
        email.openMail();
    }
}
