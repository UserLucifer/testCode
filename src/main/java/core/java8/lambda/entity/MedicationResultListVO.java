package core.java8.lambda.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Liu Yan
 * @create: 2022-01-13 11:29
 **/
@Data
public class MedicationResultListVO {

    private String medicationTime;

    private List<MedicationResultDataVO> medicationResultVoList;

    public MedicationResultListVO () {

    }


}
