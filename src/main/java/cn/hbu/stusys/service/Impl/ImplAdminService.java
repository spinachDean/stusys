package cn.hbu.stusys.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hbu.stusys.dao.AdminDAO;
import cn.hbu.stusys.service.IAdminService;
import cn.hbu.stusys.util.MD5Util;

@Service
public class ImplAdminService implements IAdminService {
	Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	AdminDAO adminDAO;

	public int batchInsertStudents(String begin, String end, String password) {
		Long first, last;
		try {
			first = new Long(begin);
			last = new Long(end);
		} catch (Exception e) {
			logger.error("批量插入时，起止学号传入有错误");
			return 0;
		}
		if (last < first) {
			logger.info("批量插入时，结束学号比开始学号小");
			return 0;
		}
		List<String> ids = new ArrayList<String>();
		while (last >= first) {
			ids.add(first + "");
			first++;
		}
		return adminDAO.batchInsertStudents(ids,MD5Util.EncoderByMd5(password));

	}

}
