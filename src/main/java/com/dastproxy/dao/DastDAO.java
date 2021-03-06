package com.dastproxy.dao;

import java.util.List;

import com.dastproxy.model.BreezeScanVO;
import com.dastproxy.model.Issue;
import com.dastproxy.model.ProxyEntity;
import com.dastproxy.model.Recording;
import com.dastproxy.model.RecordingBatch;
import com.dastproxy.model.Scan;
import com.dastproxy.model.ScanBatch;

public interface DastDAO {

	public void saveEntity(ProxyEntity proxyEntity);
	public List<ProxyEntity> getEntities();
	public boolean removeEntity(ProxyEntity proxyEntity);
	
	public void saveScan(Scan scan);
	public List<Scan> getScansToBeTracked();
	public List<Scan> getAllScans();
	public List<Scan> getRecentScansWithTestsuiteNameAndSameOwner(String testSuiteName, String owner);

	
	//Below are DAO functions for Getting Metrics
	public List getActiveUserList();
	public Long getNoOfScansSuccessfullyRun();
	public Long getNoOfScansSetUpButNotRun();
	public Long getNoOfScansSetUpButInError();
	
	public Long getNoOfScansSetupViaBluefin();
	public Long getNoOfScansSetupViaDASTUI();
	
	public List getScanOverMonthsData();
	
	public Issue getIssue(String issueId, String reportId);
	/*public Issue getIssues(String userId, String scanId, String reportId);*/
	public void saveIssue(Issue issue);
	
	public void saveGenericEntity(Object object);
	public List<Recording> getAllRecordings();
	public Recording getRecording(Long recordingId);
	public List<Scan> getScansByUser(String userId);
	public Scan getScan(String scanId);
	
	public List<RecordingBatch> getRecordingBatches(String userId);
	public List<ScanBatch> getScanBatches(String userId);
	public List<Recording> getRecordingsByBatchId(Long recordingBatchId);
	public RecordingBatch getRecordingBatch(Long id);
	public void saveScanBatch(ScanBatch scanBatch);
	public ScanBatch getScanBatch(String userId, Long id);
	public RecordingBatch getManualRecordingBatch(String owner);
	public RecordingBatch getRecBatchByTsDynamicIdentifier(String owner, String tsDynIdentifier);
	public ScanBatch getScanBatchByRecordingBatchId(String owner, Long recordingBatchId);
		
	
}
