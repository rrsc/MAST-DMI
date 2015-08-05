

package com.rmsi.mast.viewer.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.MetaValue;
import org.springframework.transaction.annotation.Transactional;

import com.rmsi.mast.studio.domain.AttributeCategory;
import com.rmsi.mast.studio.domain.AttributeValues;
import com.rmsi.mast.studio.domain.EducationLevel;
import com.rmsi.mast.studio.domain.Gender;
import com.rmsi.mast.studio.domain.GroupType;
import com.rmsi.mast.studio.domain.LandType;
import com.rmsi.mast.studio.domain.LandUseType;
import com.rmsi.mast.studio.domain.MaritalStatus;
import com.rmsi.mast.studio.domain.NaturalPerson;
import com.rmsi.mast.studio.domain.NonNaturalPerson;
import com.rmsi.mast.studio.domain.OccupancyType;
import com.rmsi.mast.studio.domain.Person;
import com.rmsi.mast.studio.domain.PersonType;
import com.rmsi.mast.studio.domain.ProjectArea;
import com.rmsi.mast.studio.domain.ShareType;
import com.rmsi.mast.studio.domain.SlopeValues;
import com.rmsi.mast.studio.domain.SocialTenureRelationship;
import com.rmsi.mast.studio.domain.SoilQualityValues;
import com.rmsi.mast.studio.domain.SourceDocument;
import com.rmsi.mast.studio.domain.Status;
import com.rmsi.mast.studio.domain.TenureClass;
import com.rmsi.mast.studio.domain.Unit;
import com.rmsi.mast.studio.domain.fetch.AttributeValuesFetch;
import com.rmsi.mast.studio.domain.fetch.PersonAdministrator;
import com.rmsi.mast.studio.domain.fetch.SpatialUnitTable;
import com.rmsi.mast.studio.domain.fetch.SpatialUnitTemp;
import com.rmsi.mast.studio.domain.fetch.SpatialunitPersonadministrator;
import com.rmsi.mast.studio.domain.fetch.SpatialunitPersonwithinterest;
import com.rmsi.mast.studio.domain.fetch.Usertable;

public interface LandRecordsService {

	/** 
	 * @return All SpatialUnit
	 *  @param Project_name
	 **/
	List<SpatialUnitTable> findAllSpatialUnit(String defaultProject);

	/**
	 * @return Approve Status and maintain History
	 *  @param Usin and User_id
	 **/
	@Transactional
	boolean updateApprove(Long id,long userid);

	/**
	 * @return Reject Status and maintain History
	 * @param Usin and User_id
	 **/
	@Transactional
	boolean rejectStatus(Long id, long userid);

	/**
	 * @return Search result from spatial_unit
	 *  @param Parameteres define in search 
	 **/
	List<SpatialUnitTable> search(String usinStr, String ukaNumber,String projname, String dateto, String datefrom, Long status,Integer startpos);


	/**
	 * @return  All Status from Status Table
	 **/
	List<Status> findallStatus();

	/**
	 * @return spatialUnit Object
	 *  @param Usin
	 **/
	List<SpatialUnitTable> findSpatialUnitbyId(Long id);

	/**
	 * @return spatial Unit result from spatial_unit Table
	 **/
	List<SpatialUnitTable> findAllSpatialUnitlist();

	/**
	 * @return boolean
	 * @category persist
	 * @param  spatialUnit Object
	 **/
	@Transactional
	boolean  update(SpatialUnitTable spatialUnit);

	/**
	 * @return  SocialTenure result from SocialTenureRelationship Table
	 **/
	List<SocialTenureRelationship> findAllSocialTenure();

	/**
	 * @return Natural Person list
	 *  @param Person_Gid
	 **/
	List<NaturalPerson> naturalPersonById(Long id);

	/**
	 * @return All Gender result from Gender Table 
	 **/
	List<Gender> findAllGenders();

	/**
	 * @return Gender Object 
	 * @param Gender_Id
	 **/
	Gender findGenderById(Long genderid);

	/**
	 * @return Boolean
	 * @category Persist
	 * @param naturalPerson Object
	 **/
	@Transactional
	NaturalPerson editnatural(NaturalPerson naturalPerson);

	/**
	 * @return MaritalStatus obj
	 *  @param Marital_Id
	 **/
	MaritalStatus findMaritalById(int maritalid);

	/**
	 * @return PersonType Object
	 * @param PersonType_ID
	 **/
	PersonType findPersonTypeById(long persontype);

	/**
	 * @return All MaritalStatus result from MaritalStatus Table
	 **/
	List<MaritalStatus> findAllMaritalStatus();

	/** 
	 * @return SocialTenureList
	 * @param Usin
	 **/
	List<SocialTenureRelationship> findAllSocialTenureByUsin(Long id);

	/**
	 * @return Non Natural Person
	 * @param  Person_Gid
	 **/
	List<NonNaturalPerson> nonnaturalPersonById(Long id);

	/**
	 * @return Boolean
	 * @param nonnaturalPerson
	 * @category Persist
	 *  
	 **/
	@Transactional
	boolean editNonNatural(NonNaturalPerson nonnaturalPerson);

	/**
	 * @return Share Object 
	 *  @param Share_Id
	 **/ 
	ShareType findTenureType(Long type);

	/**
	 * @return boolean 
	 * @category Persists
	 * @param socialTenureRelationship Object
	 **/
	@Transactional
	boolean edittenure(SocialTenureRelationship socialTenureRelationship);

	/**
	 * @return  Person Object
	 *  @param Person_Gid
	 **/ 
	Person findPersonGidById(long persontype);

	/**
	 * @return OccupancyType Object
	 *  @param OccupancyType_id
	 **/ 
	OccupancyType findOccupancyTyoeById(int occid);

	/**
	 * @return TenureClass Object
	 *  @param TenureClass_id
	 **/ 
	TenureClass findtenureClasseById(int tenureclassid);

	/**
	 * @return SocialTenureList
	 * @param socialTenure_gid
	 **/
	List<SocialTenureRelationship> findSocialTenureByGid(Integer id);

	/**
	 * @return All shareType
	 **/
	List<ShareType> findAllTenureList();

	/**
	 * @return All SourceDocument
	 *  @param Usin
	 **/
	List<SourceDocument> findMultimediaByUsin(Long id);

	/**
	 * @return  All SourceDocument
	 **/
	List<SourceDocument> findAllMultimedia();

	/**
	 * @return Boolean
	 * @category Persists
	 * @param  sourceDocument Object
	 **/
	@Transactional
	boolean updateMultimedia(SourceDocument sourceDocument);

	/**
	 * @return SourceDocument
	 * @param sourcedocument_Gid
	 **/
	List<SourceDocument> findMultimediaByGid(Long id);

	/**
	 * @return boolean
	 * @param sourcedocument_gid
	 * @category Delete (false source document)
	 **/
	@Transactional
	boolean deleteMultimedia(Long id);

	/**
	 * @return Boolean
	 * @param  person_gid
	 * @category Delete (false SocialTenureRelationship)
	 **/
	@Transactional
	boolean deleteNatural(Long id);

	/**
	 * @return Boolean 
	 * @param person_gid
	 * @category Delete(false SocialTenureRelationship) 
	 **/
	@Transactional
	boolean deleteNonNatural(Long id);

	/**
	 * @return Boolean
	 *  @param socialtenure_gid
	 *  @category Delete (False SocialTenureRelationship)
	 **/
	@Transactional
	boolean deleteTenure(Long id);

	/**
	 * @return status object
	 *  @param status_id
	 **/
	Status findAllSTatus(Long statusId);

	/**
	 * @return  All Education level from Table
	 *  
	 **/
	List<EducationLevel> findAllEducation();

	/** 
	 * @return All LandUseType from Table 
	 **/
	List<LandUseType> findAllLanduserType();

	/**
	 * @return  All TenureClass from Table 
	 **/
	List<TenureClass> findAllTenureClass();

	/**
	 * @return  EducationLevel Object
	 * @param EducationLevel_Id
	 **/
	EducationLevel findEducationById(Long education);

	/**
	 * @param LandUseType_Id  
	 *  @return LandUseType Object
	 **/
	LandUseType findLandUseById(int existingUse);

	/**
	 * @return LandUseType Object
	 * @param LandUseType_Id
	 **/
	LandUseType findProposedUseById(int proposedUse);

	/**
	 * 
	 * @param userid
	 * @return Usertable
	 **/
	Usertable findUserByID(int userid);

	/**
	 * @return UKA_number
	 * @param Usin
	 **/
	String findukaNumberByUsin(Long id);


	/**
	 * 
	 * @return All  OccupancyType from table
	 */
	List<OccupancyType> findAllOccupancyTypes();

	//List<SpatialUnitStatusHistory> findAllStatusHistory();

	/**
	 * @param measurement_unit
	 * @return Unit Object
	 */
	Unit findAllMeasurementUnit(String measurement_unit);

	/**
	 * 
	 * @return All AttributeCategory from table
	 */
	List<AttributeCategory> findAllAttributeCategories();

	/**
	 * 
	 * @param parentid
	 * @param id
	 * @return list of AttributeValuesFetch 
	 */
	List<AttributeValuesFetch> findAttributelistByCategoryId(Long parentid, Long id);

	/**
	 * @return Boolean
	 * @param value_key
	 * @param alias
	 * @category Update(Alias By value_key )
	 */
	@Transactional
	boolean updateAttributeValues(Long value_key, String alias);

	/**
	 * 
	 * @category Status Final
	 * @param usin
	 * @param userid
	 * @return Boolean
	 **/
	@Transactional
	boolean updateFinal(Long id, long userid);


	/**
	 * 
	 * @category Persist
	 * @param sourceDocument
	 * @return SourceDocument
	 */
	@Transactional
	SourceDocument saveUploadedDocuments(SourceDocument sourceDocument);

	/**
	 * 
	 * @category Adjudicated Status
	 * @param id
	 * @param userid
	 * @return Boolean
	 */
	@Transactional
	boolean updateAdjudicated(Long id, long userid);

	/**
	 * @param SourceDocument_gid
	 * @return SourceDocument
	 */
	SourceDocument getDocumentbyGid(Long id);

	/**
	 * 
	 * @param projectName
	 * @return List<ProjectArea>
	 */
	List<ProjectArea> findProjectArea(String projectName);

	/**
	 * 
	 * 
	 * @return All SoilQualityValues from Table
	 */
	List<SoilQualityValues> findAllsoilQuality();

	/**
	 * 
	 * @return All SlopeValues from Table
	 */
	List<SlopeValues> findAllSlopeValues();

	/** 
	 * @return All LandType from table
	 **/
	List<LandType> findAllLandType();

	/**
	 * @param quality_soil
	 * @return SoilQualityValues Object
	 **/
	SoilQualityValues findSoilQuality(int quality_soil);

	/**
	 * @param slope_values
	 * @return SlopeValues Object
	 */
	SlopeValues findSlopeValues(int slope_values);

	/**
	 * @param land_type
	 * @return LandType Object
	 */
	LandType findLandType(int land_type);

	/**
	 * @return All GroupType from Table 
	 */
	List<GroupType> findAllGroupType();

	/**
	 * 
	 * 
	 * @param group_type
	 * @return GroupType Object
	 */
	GroupType findGroupType(int group_type);

	/**
	 * 
	 * @category update CCro status and maintain History
	 * @param usin
	 * @param userid
	 * @return Boolean
	 */
	@Transactional
	boolean updateCCRO(Long id, long userid);

	/**
	 * @param defaultProject
	 * @param startfrom
	 * @return list SpatialUnitTemp
	 */
	List<SpatialUnitTemp> findAllSpatialUnitTemp(String defaultProject,int startfrom);

	/**
	 * @param usin
	 * @return List natura_gid (Owner True)
	 */
	ArrayList<Long> findOwnerPersonByUsin(Long id);

	/**
	 * @param usin
	 * @return  List AdminId 
	 **/
	List<Long> getAdminId(Long id);

	/**
	 * @param AdminID
	 * @return PersonAdministrator Object
	 **/
	PersonAdministrator getAdministratorById(Long admiLong);

	/**
	 * 
	 * @param adminID
	 * @return SourceDocument Object
	 */
	SourceDocument getdocumentByAdminId(Long adminID);

	/**
	 * @param defaultProject
	 * @return Total spatial_unit Records
	 */
	Integer AllSpatialUnitTemp(String defaultProject);


	/**
	 * @return Boolean
	 * @category Delete (spatial unit  false)
	 * @param usin
	 **/
	@Transactional
	boolean deleteSpatialUnit(Long id);

	/**
	 * @return Deleted Person List
	 * @param usin
	 **/  
	List<SocialTenureRelationship> showDeletedPerson(Long id);

	/**
	 * @param person_gid
	 * @return boolean
	 * @category Add (true socialTenure Object)
	 **/
	@Transactional
	boolean addDeletedPerson(Long gid);

	/**
	 * 
	 * @param usinStr
	 * @param ukaNumber
	 * @param projname
	 * @param dateto
	 * @param datefrom
	 * @param status
	 * @return total Rows of result
	 */
	Integer searchListSize(String usinStr, String ukaNumber, String projname,
			String dateto, String datefrom, long status);

	/**
	 * @param Person_Gid
	 * @return  Source Document
	 **/
	SourceDocument getdocumentByPerson(Long person_gid);

	/**
	 * @param Person Administrator Object
	 * @category Make Persist Admin Object
	 * @return boolean
	 **/
	@Transactional
	PersonAdministrator editAdmin(PersonAdministrator personobj);

	/**
	 * @param adminId
	 * @category set active false PersonAdmin
	 * @return boolean 
	 */
	@Transactional
	boolean deleteAdminById(Long id);

	/**
	 * @return Boolean
	 * @param AdminId
	 * @category Add( true PersonAdmin )
	 **/
	@Transactional
	boolean addAdminById(Long adminId);

	/**
	 * @return  SpatialunitPersonadministrator Object
	 * @category Persist
	 * @param  SpatialunitPersonadministrator Object
	 **/
	@Transactional
	SpatialunitPersonadministrator updateSpatialAdmin(SpatialunitPersonadministrator spaobj);

	/**
	 * @return natural custom attributes
	 * @param Project_name
	 **/
	List<String> findnaturalCustom(String project);

	/**
	 * @return boolean
	 * @category Persist 
	 * @param AttributeValues Object
	 **/
	@Transactional
	boolean saveAttributealues(AttributeValues tmpvalue);

	List<SpatialunitPersonwithinterest> findpersonInterestByUsin(Long usin);

	List<SpatialUnitTemp> findSpatialUnitforUKAGeneration(String project);
	
	@Transactional
	void addSpatialUnitTemp(SpatialUnitTemp spatialunitmp);

	List<Long> findUsinforUKAGeneration(String project, String hamletCode);
	@Transactional
	boolean updateUKAnumber(Long long1, String uka);
	
	

}