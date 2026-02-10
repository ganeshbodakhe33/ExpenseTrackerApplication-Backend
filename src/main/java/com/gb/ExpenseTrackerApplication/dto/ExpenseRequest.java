import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ExpenseRequest {

    @NotBlank
    private String title;

    @Positive
    private Double amount;

    @NotBlank
    private String category;

    @NotNull
    private LocalDate date;
}
