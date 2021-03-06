/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.micro.maintainance.task.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.micro.maintainance.task.model.CandidateMaintenance;
import com.liferay.micro.maintainance.task.model.CandidateMaintenanceModel;
import com.liferay.micro.maintainance.task.model.CandidateMaintenanceSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CandidateMaintenance service. Represents a row in the &quot;Task_CandidateMaintenance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link CandidateMaintenanceModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CandidateMaintenanceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateMaintenanceImpl
 * @see CandidateMaintenance
 * @see CandidateMaintenanceModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class CandidateMaintenanceModelImpl extends BaseModelImpl<CandidateMaintenance>
	implements CandidateMaintenanceModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a candidate maintenance model instance should use the {@link CandidateMaintenance} interface instead.
	 */
	public static final String TABLE_NAME = "Task_CandidateMaintenance";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "candidateMaintenanceId", Types.BIGINT },
			{ "candidateEntryId", Types.BIGINT },
			{ "taskEntryId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("candidateMaintenanceId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("candidateEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("taskEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table Task_CandidateMaintenance (uuid_ VARCHAR(75) null,candidateMaintenanceId LONG not null primary key,candidateEntryId LONG,taskEntryId LONG,createDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table Task_CandidateMaintenance";
	public static final String ORDER_BY_JPQL = " ORDER BY candidateMaintenance.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Task_CandidateMaintenance.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.micro.maintainance.task.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.micro.maintainance.task.model.CandidateMaintenance"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.micro.maintainance.task.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.micro.maintainance.task.model.CandidateMaintenance"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.micro.maintainance.task.service.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.micro.maintainance.task.model.CandidateMaintenance"),
			true);
	public static final long CANDIDATEENTRYID_COLUMN_BITMASK = 1L;
	public static final long TASKENTRYID_COLUMN_BITMASK = 2L;
	public static final long UUID_COLUMN_BITMASK = 4L;
	public static final long CREATEDATE_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CandidateMaintenance toModel(
		CandidateMaintenanceSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CandidateMaintenance model = new CandidateMaintenanceImpl();

		model.setUuid(soapModel.getUuid());
		model.setCandidateMaintenanceId(soapModel.getCandidateMaintenanceId());
		model.setCandidateEntryId(soapModel.getCandidateEntryId());
		model.setTaskEntryId(soapModel.getTaskEntryId());
		model.setCreateDate(soapModel.getCreateDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CandidateMaintenance> toModels(
		CandidateMaintenanceSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CandidateMaintenance> models = new ArrayList<CandidateMaintenance>(soapModels.length);

		for (CandidateMaintenanceSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.micro.maintainance.task.service.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.micro.maintainance.task.model.CandidateMaintenance"));

	public CandidateMaintenanceModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _candidateMaintenanceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCandidateMaintenanceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _candidateMaintenanceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CandidateMaintenance.class;
	}

	@Override
	public String getModelClassName() {
		return CandidateMaintenance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("candidateMaintenanceId", getCandidateMaintenanceId());
		attributes.put("candidateEntryId", getCandidateEntryId());
		attributes.put("taskEntryId", getTaskEntryId());
		attributes.put("createDate", getCreateDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long candidateMaintenanceId = (Long)attributes.get(
				"candidateMaintenanceId");

		if (candidateMaintenanceId != null) {
			setCandidateMaintenanceId(candidateMaintenanceId);
		}

		Long candidateEntryId = (Long)attributes.get("candidateEntryId");

		if (candidateEntryId != null) {
			setCandidateEntryId(candidateEntryId);
		}

		Long taskEntryId = (Long)attributes.get("taskEntryId");

		if (taskEntryId != null) {
			setTaskEntryId(taskEntryId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getCandidateMaintenanceId() {
		return _candidateMaintenanceId;
	}

	@Override
	public void setCandidateMaintenanceId(long candidateMaintenanceId) {
		_candidateMaintenanceId = candidateMaintenanceId;
	}

	@JSON
	@Override
	public long getCandidateEntryId() {
		return _candidateEntryId;
	}

	@Override
	public void setCandidateEntryId(long candidateEntryId) {
		_columnBitmask |= CANDIDATEENTRYID_COLUMN_BITMASK;

		if (!_setOriginalCandidateEntryId) {
			_setOriginalCandidateEntryId = true;

			_originalCandidateEntryId = _candidateEntryId;
		}

		_candidateEntryId = candidateEntryId;
	}

	public long getOriginalCandidateEntryId() {
		return _originalCandidateEntryId;
	}

	@JSON
	@Override
	public long getTaskEntryId() {
		return _taskEntryId;
	}

	@Override
	public void setTaskEntryId(long taskEntryId) {
		_columnBitmask |= TASKENTRYID_COLUMN_BITMASK;

		if (!_setOriginalTaskEntryId) {
			_setOriginalTaskEntryId = true;

			_originalTaskEntryId = _taskEntryId;
		}

		_taskEntryId = taskEntryId;
	}

	public long getOriginalTaskEntryId() {
		return _originalTaskEntryId;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			CandidateMaintenance.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CandidateMaintenance toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CandidateMaintenance)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CandidateMaintenanceImpl candidateMaintenanceImpl = new CandidateMaintenanceImpl();

		candidateMaintenanceImpl.setUuid(getUuid());
		candidateMaintenanceImpl.setCandidateMaintenanceId(getCandidateMaintenanceId());
		candidateMaintenanceImpl.setCandidateEntryId(getCandidateEntryId());
		candidateMaintenanceImpl.setTaskEntryId(getTaskEntryId());
		candidateMaintenanceImpl.setCreateDate(getCreateDate());

		candidateMaintenanceImpl.resetOriginalValues();

		return candidateMaintenanceImpl;
	}

	@Override
	public int compareTo(CandidateMaintenance candidateMaintenance) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				candidateMaintenance.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CandidateMaintenance)) {
			return false;
		}

		CandidateMaintenance candidateMaintenance = (CandidateMaintenance)obj;

		long primaryKey = candidateMaintenance.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		CandidateMaintenanceModelImpl candidateMaintenanceModelImpl = this;

		candidateMaintenanceModelImpl._originalUuid = candidateMaintenanceModelImpl._uuid;

		candidateMaintenanceModelImpl._originalCandidateEntryId = candidateMaintenanceModelImpl._candidateEntryId;

		candidateMaintenanceModelImpl._setOriginalCandidateEntryId = false;

		candidateMaintenanceModelImpl._originalTaskEntryId = candidateMaintenanceModelImpl._taskEntryId;

		candidateMaintenanceModelImpl._setOriginalTaskEntryId = false;

		candidateMaintenanceModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CandidateMaintenance> toCacheModel() {
		CandidateMaintenanceCacheModel candidateMaintenanceCacheModel = new CandidateMaintenanceCacheModel();

		candidateMaintenanceCacheModel.uuid = getUuid();

		String uuid = candidateMaintenanceCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			candidateMaintenanceCacheModel.uuid = null;
		}

		candidateMaintenanceCacheModel.candidateMaintenanceId = getCandidateMaintenanceId();

		candidateMaintenanceCacheModel.candidateEntryId = getCandidateEntryId();

		candidateMaintenanceCacheModel.taskEntryId = getTaskEntryId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			candidateMaintenanceCacheModel.createDate = createDate.getTime();
		}
		else {
			candidateMaintenanceCacheModel.createDate = Long.MIN_VALUE;
		}

		return candidateMaintenanceCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", candidateMaintenanceId=");
		sb.append(getCandidateMaintenanceId());
		sb.append(", candidateEntryId=");
		sb.append(getCandidateEntryId());
		sb.append(", taskEntryId=");
		sb.append(getTaskEntryId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.micro.maintainance.task.model.CandidateMaintenance");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidateMaintenanceId</column-name><column-value><![CDATA[");
		sb.append(getCandidateMaintenanceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidateEntryId</column-name><column-value><![CDATA[");
		sb.append(getCandidateEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taskEntryId</column-name><column-value><![CDATA[");
		sb.append(getTaskEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = CandidateMaintenance.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			CandidateMaintenance.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _candidateMaintenanceId;
	private long _candidateEntryId;
	private long _originalCandidateEntryId;
	private boolean _setOriginalCandidateEntryId;
	private long _taskEntryId;
	private long _originalTaskEntryId;
	private boolean _setOriginalTaskEntryId;
	private Date _createDate;
	private long _columnBitmask;
	private CandidateMaintenance _escapedModel;
}