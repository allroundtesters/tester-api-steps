package io.allroundtester.setup.order;

import java.time.LocalDateTime;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * <p>
 *
 * </p>
 *
 * @author patrick
 * @since 2019-05-08
 */
@Data
@Builder
@Accessors(chain = true)
@ApiModel(value = "Order对象", description = "订单")
@Entity
public class Order  {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Integer id;
    @ApiModelProperty(value = "product")
    private String product;

    @ApiModelProperty(value = "quantity")
    private Integer quantity;

    @ApiModelProperty(value = "price per unit")
    private Double pricePerUnit;

    @ApiModelProperty(value = "total price")
    private Double totalPrice;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String createdBy;

    private String updatedBy;


}
