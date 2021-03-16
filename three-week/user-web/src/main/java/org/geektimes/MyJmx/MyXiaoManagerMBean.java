package org.geektimes.MyJmx;

import java.util.Date;

public interface MyXiaoManagerMBean {
     Long getId();

     void setId(Long id) ;

     String getName() ;

     void setName(String name) ;

     Double getAge() ;

     void setAge(Double age);

     Date getTime() ;

     void setTime(Date time);
     String toString();
}
