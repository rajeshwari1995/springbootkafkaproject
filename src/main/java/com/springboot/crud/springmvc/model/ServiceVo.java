package com.springboot.crud.springmvc.model;

import java.util.List;

public class ServiceVo extends XMLVO{
public ServiceVo()
{
	super();
}
private String templateName;
private String templateType;
private String templateVersion;
List<SourceContext> sourceContext;

public List<SourceContext> getSourceContext() {
	return sourceContext;
}
public void setSourceContext(List<SourceContext> sourceContext) {
	this.sourceContext = sourceContext;
}
public String getTemplateName() {
	return templateName;
}
public void setTemplateName(String templateName) {
	this.templateName = templateName;
}
public String getTemplateType() {
	return templateType;
}
public void setTemplateType(String templateType) {
	this.templateType = templateType;
}
public String getTemplateVersion() {
	return templateVersion;
}
public void setTemplateVersion(String templateVersion) {
	this.templateVersion = templateVersion;
}

}
