package ${packageName}.service.impl;
import ${packageName}.service.${table.className}Service;
import ${packageName}.mapper.${table.className}Mapper;
import ${packageName}.bean.${table.className};
import ${packageName}.util.EmptyUtils;
import ${packageName}.util.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import ${packageName}.util.Constants;

@Service("${table.firstLowerCaseClassName}Service")
public class ${table.className}ServiceImpl implements ${table.className}Service {

    @Resource
    private ${table.className}Mapper ${table.firstLowerCaseClassName}Mapper;

    public ${table.className} get${table.className}ById(Long id)throws Exception{
        return ${table.firstLowerCaseClassName}Mapper.get${table.className}ById(id);
    }

    public List<${table.className}> get${table.className}ListByMap(Map<String,Object> param)throws Exception{
        return ${table.firstLowerCaseClassName}Mapper.get${table.className}ListByMap(param);
    }

    public Integer get${table.className}CountByMap(Map<String,Object> param)throws Exception{
        return ${table.firstLowerCaseClassName}Mapper.get${table.className}CountByMap(param);
    }

    public Integer save${table.className}(${table.className} ${table.firstLowerCaseClassName})throws Exception{
            ${table.firstLowerCaseClassName}.setCreationDate(new Date());
            return ${table.firstLowerCaseClassName}Mapper.save${table.className}(${table.firstLowerCaseClassName});
    }

    public Integer modify${table.className}(${table.className} ${table.firstLowerCaseClassName})throws Exception{
        ${table.firstLowerCaseClassName}.setModifyDate(new Date());
        return ${table.firstLowerCaseClassName}Mapper.modify${table.className}(${table.firstLowerCaseClassName});
    }

    public Integer remove${table.className}ById(Long id)throws Exception{
        return ${table.firstLowerCaseClassName}Mapper.remove${table.className}ById(id);
    }

    public Page<${table.className}> query${table.className}PageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception{
        Integer total = ${table.firstLowerCaseClassName}Mapper.get${table.className}CountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<${table.className}> ${table.firstLowerCaseClassName}List = ${table.firstLowerCaseClassName}Mapper.get${table.className}ListByMap(param);
        page.setRows(${table.firstLowerCaseClassName}List);
        return page;
    }

}
