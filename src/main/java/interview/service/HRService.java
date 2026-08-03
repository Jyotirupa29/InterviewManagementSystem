package interview.service;

import java.util.List;

import interview.entity.HR;

public interface HRService {

	void saveHR(HR hr,String username, String password);

    HR updateHR(HR hr);

    void deleteHR(Integer id);

    HR getHRById(Integer id);

    List<HR> getAllHR();

}
