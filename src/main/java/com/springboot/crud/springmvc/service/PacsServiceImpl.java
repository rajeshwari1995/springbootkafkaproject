package com.springboot.crud.springmvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.crud.springmvc.config.KafkaConsumerConfig;
import com.springboot.crud.springmvc.model.Book;
import com.springboot.crud.springmvc.model.ServiceVo;
import com.springboot.crud.springmvc.model.SourceContext;
import com.springboot.crud.springmvc.util.MessageSenderUtil;

@Service("pacsProcess")
@PropertySource({"classpath:application.properties"})
public class PacsServiceImpl implements IPacsProcess {
	 private static final Logger LOGGER=LoggerFactory.getLogger(PacsServiceImpl.class);
	 
	 @Autowired
	 MessageSenderUtil messageSenderUtil; 
	 public boolean processRequest(String message)
	 {
		 ServiceVo serviceVo=new ServiceVo();
		 ObjectMapper mapper=new ObjectMapper();
		 JsonNode node=null;
		 SourceContext[] sourceContextList=null;
		 try
		 {
			 node=mapper.readTree(message);
			 JsonNode sourcecontextnode=node.get("sourceContext");
			 sourceContextList=mapper.readValue(sourcecontextnode.toString(),SourceContext[].class);
			 
			 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 for(SourceContext source:sourceContextList)
		 {
			 if(source.getName().equals("from"))
				 serviceVo.setFrom(source.getValue());
			 if(source.getName().equals("toAddress"))
				 serviceVo.setToAddress(source.getValue());
		 }
		 try {
			 
		 serviceVo.setTemplateType(node.get("templateType").toString().replace("\"",""));
		 serviceVo.setTemplateName(node.get("templateName").toString().replace("\"",""));
		 serviceVo.setTemplateVersion(node.get("templateVersion").toString().replace("\"", ""));
		 LOGGER.debug("file");
		 messageSenderUtil.sendMessage(serviceVo);
		 return true;
	 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 return false;
		 }
	 
			 }
	 
}

