INSERT  INTO
	jeecg_p3demo
      ( 
      id                            
      ,create_name                    
      ,create_by                      
      ,create_date                    
      ,update_name                    
      ,update_by                      
      ,update_date                    
      ,sys_org_code                   
      ,sys_company_code               
      ,bpm_status                     
      ,name                           
      ,sex                            
      ,age                            
      ,address                        
      ,phone                          
      ,memo                           
      ) 
values
      (
      :jeecgP3demo.id                            
      ,:jeecgP3demo.createName                    
      ,:jeecgP3demo.createBy                      
      ,:jeecgP3demo.createDate                    
      ,:jeecgP3demo.updateName                    
      ,:jeecgP3demo.updateBy                      
      ,:jeecgP3demo.updateDate                    
      ,:jeecgP3demo.sysOrgCode                    
      ,:jeecgP3demo.sysCompanyCode                
      ,:jeecgP3demo.bpmStatus                     
      ,:jeecgP3demo.name                          
      ,:jeecgP3demo.sex                           
      ,:jeecgP3demo.age                           
      ,:jeecgP3demo.address                       
      ,:jeecgP3demo.phone                         
      ,:jeecgP3demo.memo                          
      )