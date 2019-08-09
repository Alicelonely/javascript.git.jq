/**
 *  用 require()引入  引入文件的时候，一定要写.路径，即使目录相同也要从./触发
 *              
 *          每一个文件都是一个单独的作用域,所以在引入别的文件的时候，变量是不会互相污染的
 * 
 *  require()   引入
 *  exports     导出 相当于return  有开发着决定数据的变量名
 */

// let getX =  require("./demo");
//console.log(getX); 

let {sum:afei} = require("./demo");

console.log(afei(1,2,3,4));

