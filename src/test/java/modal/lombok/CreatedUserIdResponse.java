package modal.lombok;

import lombok.Data;

@Data
public class CreatedUserIdResponse {
    private String name;
    private String job;
    private Integer id;
    private String createdAt;
}
