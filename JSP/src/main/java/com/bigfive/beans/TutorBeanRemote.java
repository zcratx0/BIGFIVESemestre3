package com.bigfive.beans;

import javax.ejb.Remote;

import com.bigfive.entities.Tutor;

@Remote

public interface TutorBeanRemote extends ICrud<Tutor>{

}
