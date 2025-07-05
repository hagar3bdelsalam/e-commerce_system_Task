import java.util.Date;
public interface Expirable {
    boolean isExpired();
    Date getExpirationDate();
}
