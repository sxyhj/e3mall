package cn.itcast.core.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.itcast.core.pojo.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SolrServer solrServer;
	
	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		try {
			SolrQuery query = new SolrQuery();
	
			query.set("q", "*:*");

			query.set("df", "product_keywords");
		
			QueryResponse response = solrServer.query(query);
			
			SolrDocumentList results = response.getResults();
			
			for (SolrDocument solrDocument : results) {
				User user = new User();
				user.setId(Integer.valueOf((String)solrDocument.get("id")));
				user.setName((String) solrDocument.get("u_name"));
				user.setBirthday((Date)solrDocument.get("birthday"));
				list.add(user);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
