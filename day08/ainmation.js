function animation(dom, targetJson, time, callback) {

    let startJson = {};

    let speedJson = {};


    //计算速度
    for (let key in targetJson) {
        startJson[key] = getStyle(dom, key);
        speedJson[key] = (targetJson[key] - startJson[key]) / (time * 1000);
    }


    //获取初试时间
    let startTime = new Date();

    //设置定时器
    let timer = setInterval(function () {
        //获取时间差
        let _time = new Date() - startTime;

        for (let key in targetJson) {

            dom.style[key] = key == "opacity" ? startJson[key] + _time * speedJson[key] : startJson[key] + _time * speedJson[key] + 'px';

            //判断收尾
            if (_time >= time * 1000) {

                dom.style[key] = key == "opacity" ? targetJson[key] : targetJson[key] + 'px';

            }
        }

        if (_time >= time * 1000) {

            clearInterval(timer);

            callback && callback.call(dom, startJson, time);

        }


    }, 20)
}


//兼容函数
function getStyle(dom, attr) {
    return dom.currentStyle ? parseFloat(dom.currentStyle[attr]) : parseFloat(getComputedStyle(dom)[attr]);
}