package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Datum
{

@SerializedName("id")
@Expose
private Long id;
@SerializedName("username")
@Expose
private String username;
@SerializedName("about")
@Expose
private String about;
@SerializedName("submitted")
@Expose
private Long submitted;
@SerializedName("updated_at")
@Expose
private String updatedAt;
@SerializedName("submission_count")
@Expose
private Long submissionCount;
@SerializedName("comment_count")
@Expose
private Long commentCount;
@SerializedName("created_at")
@Expose
private Long createdAt;

/**
* No args constructor for use in serialization
*
*/
public Datum() {
}

/**
*
* @param createdAt
* @param submitted
* @param about
* @param submissionCount
* @param id
* @param username
* @param updatedAt
* @param commentCount
*/
public Datum(Long id, String username, String about, Long submitted, String updatedAt, Long submissionCount, Long commentCount, Long createdAt) {
super();
this.id = id;
this.username = username;
this.about = about;
this.submitted = submitted;
this.updatedAt = updatedAt;
this.submissionCount = submissionCount;
this.commentCount = commentCount;
this.createdAt = createdAt;
}

public Long getId() {
return id;
}

public void setId(Long id) {
this.id = id;
}

public String getUsername() {
return username;
}

public void setUsername(String username) {
this.username = username;
}

public String getAbout() {
return about;
}

public void setAbout(String about) {
this.about = about;
}

public Long getSubmitted() {
return submitted;
}

public void setSubmitted(Long submitted) {
this.submitted = submitted;
}

public String getUpdatedAt() {
return updatedAt;
}

public void setUpdatedAt(String updatedAt) {
this.updatedAt = updatedAt;
}

public Long getSubmissionCount() {
return submissionCount;
}

public void setSubmissionCount(Long submissionCount) {
this.submissionCount = submissionCount;
}

public Long getCommentCount() {
return commentCount;
}

public void setCommentCount(Long commentCount) {
this.commentCount = commentCount;
}

public Long getCreatedAt() {
return createdAt;
}

public void setCreatedAt(Long createdAt) {
this.createdAt = createdAt;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("id", id).append("username", username).append("about", about).append("submitted", submitted).append("updatedAt", updatedAt).append("submissionCount", submissionCount).append("commentCount", commentCount).append("createdAt", createdAt).toString();
}

@Override
public int hashCode() {
return new HashCodeBuilder().append(createdAt).append(submitted).append(about).append(submissionCount).append(id).append(username).append(updatedAt).append(commentCount).toHashCode();
}

@Override
public boolean equals(Object other) {
if (other == this) {
return true;
}
if ((other instanceof Datum) == false) {
return false;
}
Datum rhs = ((Datum) other);
return new EqualsBuilder().append(createdAt, rhs.createdAt).append(submitted, rhs.submitted).append(about, rhs.about).append(submissionCount, rhs.submissionCount).append(id, rhs.id).append(username, rhs.username).append(updatedAt, rhs.updatedAt).append(commentCount, rhs.commentCount).isEquals();
}

}