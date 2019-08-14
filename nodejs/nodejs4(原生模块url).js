/**
 *      url模块
 *                     
 * 
 */


 const {URL} = require("url");      //取出一个类

let u = new URL("网址路径");

console.log(u.searchParams.get("wd"));  //解析路径，把路径的每一段截断，便于调用

 console.log(URL);