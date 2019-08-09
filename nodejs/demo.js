// console.log("hello world");

// let x = 10;

// exports.x = 10;

function sum(...rest){

   return [...rest].reduce((a,b)=>a+b);

}

exports.sum = sum;