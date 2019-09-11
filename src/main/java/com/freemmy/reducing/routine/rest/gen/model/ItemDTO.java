package com.freemmy.reducing.routine.rest.gen.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/** * ItemDTO
 */
@Validated

public class ItemDTO   {
  @JsonProperty("id")
    private Long id;

  @JsonProperty("productId")
    private Long productId;

  @JsonProperty("manufacturer")
    private String manufacturer;

  @JsonProperty("name")
    private String name;

  public ItemDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**     * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ItemDTO productId(Long productId) {
    this.productId = productId;
    return this;
  }

  /**     * Get productId
   * @return productId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public ItemDTO manufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
    return this;
  }

  /**     * Get manufacturer
   * @return manufacturer
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

@Size(max=128) 
  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public ItemDTO name(String name) {
    this.name = name;
    return this;
  }

  /**     * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

@Size(max=128) 
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ItemDTO item = (ItemDTO) o;
    return Objects.equals(this.id, item.id) &&
        Objects.equals(this.productId, item.productId) &&
        Objects.equals(this.manufacturer, item.manufacturer) &&
        Objects.equals(this.name, item.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, productId, manufacturer, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    manufacturer: ").append(toIndentedString(manufacturer)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

