package ${packageName}.service;
import ${packageName}.bean.${table.className};
import java.util.List;
import java.util.Map;
import ${packageName}.util.Page;


public interface ${table.className}Service {

    public ${table.className} get${table.className}ById(Long id)throws Exception;

    public List<${table.className}>	get${table.className}ListByMap(Map<String,Object> param)throws Exception;

    public Integer get${table.className}CountByMap(Map<String,Object> param)throws Exception;

    public Integer save${table.className}(${table.className} ${table.firstLowerCaseClassName})throws Exception;

    public Integer modify${table.className}(${table.className} ${table.firstLowerCaseClassName})throws Exception;

    public Integer remove${table.className}ById(Long id)throws Exception;

    public Page<${table.className}> query${table.className}PageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception;
}
