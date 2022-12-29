package com.springboot.crud.springmvc.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.crud.springmvc.model.ServiceVo;
import com.springboot.crud.springmvc.model.SourceContext;
@Component
@Service
public class MessageSenderUtil {

	public void sendMessage(ServiceVo serviceVo) {
		 ObjectMapper mapper=new ObjectMapper();
		 String jsonresponse="";
		 try
		 {
			 SourceContext context =serviceVo.getSourceContext().get(0);
			
			 if(context!= null || context.equals(""))
			 {
				 context =serviceVo.getSourceContext().get(0);
			 SourceContext scon1=new SourceContext();
			 scon1.setName("from");
			 scon1.setValue(serviceVo.getFrom());
			 
			 SourceContext scon2=new SourceContext();
			 scon2.setName("toAddress");
			 scon2.setValue(serviceVo.getToAddress());
			 
			 SourceContext scon3=new SourceContext();
			 scon3.setName("stateCode");
			 scon3.setValue(serviceVo.getStateCode());
			 
			 List<SourceContext> list= new ArrayList<SourceContext>();
			 list.add(scon1);
			 list.add(scon2);
			 list.add(scon3);
			 mapper.setSerializationInclusion(Include.NON_NULL);
			 jsonresponse=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(serviceVo);
			 } 
			 
		 }
		 catch(JsonProcessingException e)
		 {
			 e.printStackTrace();
		 }
		
	}

}
