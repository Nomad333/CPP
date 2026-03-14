package task2.driver;

import lombok.*;

@Data
public class Driver {
    @NonNull
    private String name;
    @NonNull
    private String surname;
    @NonNull
    private String phone;
    @NonNull
    private Integer experience;
}
