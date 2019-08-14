/**
 * path模块     自定义模块不要有中文，不要有空格，尽量要小写
 * 
 *       第一个方法   join()  
 *              把两个参数路径拼接在一起
 *      第二个方法    resolve()
 *              也是路径拼接，但是一旦遇见根目录，会直接回到根目录，resolve可以解析路径
 *      第三个方法     relative()
 *              怎样从第一个路径到达第二个路径
 *      第四个方法      parse()
 *              把后面的路径格式化一下  返回一个对象
 *              root    根目录
 *              dir     文件路径
 *              ext     扩展名
 *              name    文件名
 *      
 *      
 */
const path = require("path");

let p = path.join(__dirname, "nodejs3(原生的模块).js");

//__dirname    目录的路径       __filename  文件的路径



let b = path.resolve("a/b","/user","d");


let t = path.relative("../nodejs/nodejs3(原生的模块).js","../nodejs/nodejs1(基本命令).html");


console.log(t);

console.log(b);


console.log(p);