package uz.pdp.apppcmarket1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonitorDto {
    private String name;
    private String brand;

    private String screenResolution;

    private String videoConnectors;

    private String matrix;

    private Double diagonalScreen;

    private boolean curvedScreen;

    private Integer screenRefreshRate;

    private String responseTime;
}
