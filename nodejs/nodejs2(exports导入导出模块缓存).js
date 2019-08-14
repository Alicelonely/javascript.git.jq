/**
 *  用 require()引入  引入文件的时候，一定要写.路径，即使目录相同也要从./触发
 *              
 *          每一个文件都是一个单独的作用域,所以在引入别的文件的时候，变量是不会互相污染的
 * 
 *  require()   引入
 *  exports     导出 相当于return  有开发着决定数据的变量名
 *              真正导出的是module.exports  而exports和module.exports是引用关系
 *              
 *              如果不理解就所有就module.exports导出        它的默认值是空对象
 * 
 *              
 *   模块缓存   两次引入同一个文件是没有意义的，用的就是之前的结果不会重新加载
 */

// let getX =  require("./demo");
//console.log(getX); 

let {sum:afei} = require("./demo");

console.log(afei(1,2,3,4));

