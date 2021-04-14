package com.jain.kafka.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jain.kafka.pojo.Bank;
import com.jain.kafka.util.DBUtil;

@Service
public class BankService {

	private List<Bank> bankList;

	public List<Bank> getAllBank() {
		try {
			DBUtil dbutil = new DBUtil();
			Connection con = dbutil.getConnection();
			Statement st = con.createStatement();
			String query = "select * from bank";
			ResultSet rs = st.executeQuery(query);
			bankList = new ArrayList<Bank>();
			while (rs.next()) {
				Bank bank = new Bank();
				bank.setName(rs.getString("name"));
				bank.setAllCustomers(rs.getString("allCustomers"));
				bank.setAssetValue(rs.getString("assetValue"));
				bank.setBranchAddressLine1(rs.getString("branchAddressLine1"));
				bank.setBranchAddressLine2(rs.getString("branchAddressLine2"));
				bank.setBranchAddressLine3(rs.getString("branchAddressLine3"));
				bank.setBranchCode(rs.getString("branchCode"));
				bank.setBranchType(rs.getString("branchType"));
				bank.setCity(rs.getString("city"));
				bank.setBranchid(rs.getString("branchid"));
				bank.setNoOfCustomers(rs.getString("noOfCustomers"));
				bank.setPinCode(rs.getString("pinCode"));
				bank.setState(rs.getString("state"));
				bankList.add(bank);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bankList;
	}

	public List<Bank> getBankbyBranchCode(String bcode) {
		try {
			DBUtil dbutil = new DBUtil();
			Connection con = dbutil.getConnection();
			String query = "select * from bank where branchcode=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, bcode);

			ResultSet rs = st.executeQuery();
			bankList = new ArrayList<Bank>();
			while (rs.next()) {
				Bank bank = new Bank();
				bank.setName(rs.getString("name"));
				bank.setAllCustomers(rs.getString("allCustomers"));
				bank.setAssetValue(rs.getString("assetValue"));
				bank.setBranchAddressLine1(rs.getString("branchAddressLine1"));
				bank.setBranchAddressLine2(rs.getString("branchAddressLine2"));
				bank.setBranchAddressLine3(rs.getString("branchAddressLine3"));
				bank.setBranchCode(rs.getString("branchCode"));
				bank.setBranchType(rs.getString("branchType"));
				bank.setCity(rs.getString("city"));
				bank.setBranchid(rs.getString("branchid"));
				bank.setNoOfCustomers(rs.getString("noOfCustomers"));
				bank.setPinCode(rs.getString("pinCode"));
				bank.setState(rs.getString("state"));
				bankList.add(bank);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bankList;
	}

	public int createBank(Bank bank) {
		int count=0;
		try {
			DBUtil dbutil = new DBUtil();
			Connection con = dbutil.getConnection();
			String query = "insert into bank (name,branchCode,branchAddressLine1,"
					+ "branchAddressLine2,branchAddressLine3,city,state,pinCode,assetValue,"
					+ "branchid,branchType,noOfCustomers,allCustomers) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, bank.getName());
			st.setString(2, bank.getBranchCode());
			st.setString(3, bank.getBranchAddressLine1());
			st.setString(4, bank.getBranchAddressLine2());
			st.setString(5, bank.getBranchAddressLine3());
			st.setString(6, bank.getCity());
			st.setString(7, bank.getState());
			st.setString(8, bank.getPinCode());
			
			st.setString(9, bank.getAssetValue());
			st.setString(10, bank.getBranchid());
			st.setString(11, bank.getBranchType());
			st.setString(12, bank.getNoOfCustomers());
			st.setString(13, bank.getAllCustomers());
			
			count=st.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
