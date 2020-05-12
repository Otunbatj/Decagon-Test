package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class UserDetails
{

@SerializedName("page")
@Expose
private String page;
@SerializedName("per_page")
@Expose
private Long perPage;
@SerializedName("total")
@Expose
private Long total;
@SerializedName("total_pages")
@Expose
private Long totalPages;
@SerializedName("data")
@Expose
private List<Datum> data = null;
/**
* No args constructor for use in serialization
*
*/
public UserDetails() {
}

/**
*
* @param total
* @param perPage
* @param data
* @param totalPages
* @param page
*/
public UserDetails(String page, Long perPage, Long total, Long totalPages, List<Datum> data) {
super();
this.page = page;
this.perPage = perPage;
this.total = total;
this.totalPages = totalPages;
this.data = data;
}

public String getPage() {
return page;
}

public void setPage(String page) {
this.page = page;
}

public Long getPerPage() {
return perPage;
}

public void setPerPage(Long perPage) {
this.perPage = perPage;
}

public Long getTotal() {
return total;
}

public void setTotal(Long total) {
this.total = total;
}

public Long getTotalPages() {
return totalPages;
}

public void setTotalPages(Long totalPages) {
this.totalPages = totalPages;
}

public List<Datum> getData() {
return data;
}

public void setData(List<Datum> data) {
this.data = data;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("page", page).append("perPage", perPage).append("total", total).append("totalPages", totalPages).append("data", data).toString();
}

@Override
public int hashCode() {
return new HashCodeBuilder().append(totalPages).append(total).append(page).append(perPage).append(data).toHashCode();
}

@Override
public boolean equals(Object other) {
if (other == this) {
return true;
}
if ((other instanceof UserDetails) == false) {
return false;
}
UserDetails rhs = ((UserDetails) other);
return new EqualsBuilder().append(totalPages, rhs.totalPages).append(total, rhs.total).append(page, rhs.page).append(perPage, rhs.perPage).append(data, rhs.data).isEquals();
}

}