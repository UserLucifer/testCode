package core.java8.lambda.entity;

import lombok.Data;

import java.util.List;

/**
 * @author: Liu Yan
 * @create: 2022-01-13 11:29
 **/
@Data
public class MedicationResultDataVO {
    private String id;

    private String open;

    private String drugName;

    /**
     * 提醒类型
     */
    private Integer reminderType;

    /**
     * 注意事项
     */
    private String mattersNeedingAttention;


    private String dosageNum;

    private String dosageUnit;

    private String medicationTime;

    private Integer customizeTime;

    /**
     *数据渠道
     */
    private String dataChannel;

    private List<FrequencyDto> frequencys;
}
