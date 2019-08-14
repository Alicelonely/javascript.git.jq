/**
 *      
 *      querystring
 *      用于路径解析
 *          把路径解析为字符串
 * 
 */

    const querystring = require("querystring");

    let parse = querystring.parse("网址?后面的值");   //把网址解析为一个路径对象    把路径拆分出来

    let stringify = querystring.stringify({
        wd : "阿飞"
        ,abc:789
        ,f:10   
    },';',':')          //把这些组合起来，而且还可以新增规则
