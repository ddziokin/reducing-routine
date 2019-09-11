package com.freemmy.reducing.routine.rest.gen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * ProductDTO
 */
@Validated

public class ProductDTO {

    @JsonProperty("manufacturer")
    private String manufacturer;

    @JsonProperty("name")
    private String name;

    public ProductDTO manufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    /**
     * Get manufacturer
     *
     * @return manufacturer
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Size(max = 128)
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public ProductDTO name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Size(max = 128)
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
        ProductDTO product = (ProductDTO) o;
        return Objects.equals(this.manufacturer, product.manufacturer) &&
                Objects.equals(this.name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProductDTO {\n");

        sb.append("    manufacturer: ").append(toIndentedString(manufacturer)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

