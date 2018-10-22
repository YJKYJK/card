package com.yanyan.card.mapper;
import ${packageName}.bean.${table.className};
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface ${table.className}Mapper {

	public ${table.className} get${table.className}ById(@Param(value = "id") Long id)throws Exception;

	public List<${table.className}>	get${table.className}ListByMap(Map<String,Object> param)throws Exception;

	public Integer get${table.className}CountByMap(Map<String,Object> param)throws Exception;

	public Integer save${table.className}(${table.className} ${table.firstLowerCaseClassName})throws Exception;

	public Integer modify${table.className}(${table.className} ${table.firstLowerCaseClassName})throws Exception;

	public Integer remove${table.className}ById(@Param(value = "id") Long id)throws Exception;

}
