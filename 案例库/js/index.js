window.onload = function () {

    //生成所需要的li
    (function () {
        let length = 5 * 5 * 5;       //确定生成li的总数
        oUl = document.getElementById("list").children[0],  //获取li的父级ul元素
            aLi = oUl.children;     //获取所有的li

        //初始化
        (function () {
            //循环创建len个li
            for (let i = 0; i < length; i++) {
                //创建li
                let oLi = document.createElement("li");
                //给每一个li添加相关的属性值
                oLi.index = i;
                //确定li的位置
                oLi.x = i % 5;
                oLi.y = Math.floor(i % 25 / 5);
                oLi.z = 4 - Math.floor(i / 25);


                // //获取数据
                // console.log(flyDate.length)
                
                // let date = flyDate[i] || flyDate[1];
                //添加li的内容
                oLi.innerHTML = `<b class="liCover"></b>
                <p class="liTitle">${flyDate[i].type}</p>
                <p class="liAuthor">${flyDate[i].author}</p>
                <p class="liTime">${flyDate[i].time}</p>`

                //定义li 在3D空间的随机位置
                let tX = Math.random() * 6000 - 3000,
                    tY = Math.random() * 6000 - 3000,
                    tZ = Math.random() * 6000 - 3000;

                //初始化li的位置
                oLi.style.transform = `translate3D(${tX}px,${tY}px,${tZ}px)`;

                oUl.appendChild(oLi);


            }
            setTimeout(Grid, 20);
        })();

        //关于弹窗
        (function () {
            //获取元素
            let oAlert = document.getElementById('alert'),
                aATitle = oAlert.getElementsByClassName('title')[0].getElementsByTagName('span')[0],
                oAImg = oAlert.getElementsByClassName('img')[0].getElementsByTagName('img')[0],
                oAAuthor = oAlert.getElementsByClassName('author')[0].getElementsByTagName('span')[0],
                oAInfo = oAlert.getElementsByClassName('info')[0].getElementsByTagName('span')[0];

            //获取点击弹出层需要使用的元素
            let oAll = document.getElementById("all"),
                oFrame = document.getElementById('frame'),
                oBack = document.getElementById('back');

            //通过事件委托给每一个li 添加点击事件
            oUl.onclick = function (e) {
                //获取点击事件的事件源
                let target = e.target;
                if (target.nodeName == "B") {
                    if (target.goudan) {
                        target.goudan = false;
                    } else {
                        //判断alert的状态是显示还是隐藏
                        if (oAlert.style.display === "block") {
                            //已经确定oAlert是显示状态,希望隐藏
                            hide();
                        } else {
                            //隐藏状态,需要显示

                            //获取被点击li的index 索引值
                            let index = target.parentNode.index;
                            //通过index获取对应的数据内容
                            var data = flyDate[index] || flyDate[0];
                            oAlert.index = index;
                            //修改弹窗内容
                            aATitle.innerHTML = `课题:${data.title}`;
                            oAImg.src = `src/${data.src}/index.png`;
                            oAAuthor.innerHTML = `制作:${data.author}`;
                            oAInfo.innerHTML = `描述:${data.dec}`;
                            show();
                        } 
                    }

                }

                //取消事件冒泡
                e.cancelBubble = true;

            }


            //如果点击弹窗,跳转
            oAlert.onclick = function () {

                //获取数据
                let data = flyDate[this.index] || flyDate[0];
                oFrame.src = `src/${data.src}/index.html`
                oAll.className = 'left';
                return false;
            }

            //点击返回按钮
            oBack.onclick = function () {
                oAll.className = '';
            }

            //点击空白处就消失
            document.onclick = function () {
                hide();
            }

            //点击弹出显示
            function show() {
                if (!oAlert.timer) {
                    oAlert.timer = true;
                    oAlert.style.display = "block";

                    //设置弹窗的初始位置
                    oAlert.style.transform = `rotateY(0deg) scale(2)`
                    oAlert.style.opacity = '0';
                    //定义运动的参数
                    let time = 300,
                        sTime = new Date();


                    //运动的函数,让oAlert从放大两倍的位置移动到正常大小
                    function m() {
                        let prop = (new Date() - sTime) / time;

                        if (prop >= 1) {
                            prop = 1;
                            oAlert.timer = false;
                        } else {
                            requestAnimationFrame(m);
                        }

                        oAlert.style.transform = `rotateY(0deg) scale(${2 - prop})`;
                        oAlert.style.opacity = prop;
                    }
                    requestAnimationFrame(m);
                }

            }



            //弹出隐藏
            function hide() {
                if (oAlert.style.display == "block" && !oAlert.timer) {
                    oAlert.timer = true;
                    //初始化弹出隐藏的样式
                    oAlert.style.display = 'block'
                    oAlert.style.transform = `rotateY(0deg) scale(1)`;
                    oAlert.style.opacity = "1";

                    //定义运动的参数
                    let time = 300,
                        sTime = new Date;

                    //运动的函数,让oAlert从放大0倍的大小移动到消失
                    function m() {
                        let prop = (new Date - sTime) / time;

                        if (prop >= 1) {
                            prop = 1;
                            oAlert.timer = false;
                            oAlert.style.display = 'none';
                        } else {
                            requestAnimationFrame(m);
                        }

                        oAlert.style.transform = `rotateY(${(prop * 180)}deg) scale(${(1 - prop)})`;
                        oAlert.style.opacity = 1 - prop;
                    }
                    requestAnimationFrame(m);
                }



            }


        })();


        //拖拽,滚轮事件
        (function () {
            let roX = 0,
                roY = 0,
                trZ = -2000;

            //清楚字体被选中
            document.onselectstart = function () {
                return false;
            }

            //鼠标按下事件
            document.onmousedown = function (e) {


                //定义参数变量
                let sX = e.clientX,     //鼠标点击时的x坐标
                    sY = e.clientY,     //鼠标点击时的y坐标
                    lastX = sX,         //变量用来记录鼠标移动move最后一次的x值
                    lastY = sY,         //变量用来记录鼠标移动move最后一次的y值
                    x_ = 0,               //存鼠标抬起时最后两点的差值                
                    y_ = 0;               //存鼠标抬起时最后两点的差值
                moveTime = 0,         //用来解决最后一次move的时间
                    ifTime = new Date;

                //为了解决down和up在同一个元素身上触发点击事件触发弹窗
                if (e.target.nodeName == "B") {

                    var thisLi = e.target;
                }

                //鼠标移动
                this.onmousemove = function (e) {
                    //计算鼠标移动的距离
                    x_ = e.clientX - lastX;
                    y_ = e.clientY - lastY;
                    //通过你鼠标移动的距离来计算旋转的度数
                    roX -= y_ * 0.15;
                    roY += x_ * 0.15;
                    //旋转ul
                    oUl.style.transform = `translateZ(${trZ}px) rotateX(${roX}deg) rotateY(${roY}deg)`;


                    //重新赋值
                    lastX = e.clientX;
                    lastY = e.clientY;

                    //获取每次鼠标移动后的时间
                    moveTime = new Date;
                }

                //鼠标抬起事件
                this.onmouseup = function () {
                    //判断up时的事件源和down的事件源是不是同一个
                    if (e.target == thisLi && new Date - ifTime > 500) {
                        thisLi.goudan = true;
                    }
                    //清除鼠标移动事件
                    this.onmousemove = null;

                    //计算缓冲
                    function m() {
                        //通过系数慢慢减少移动距离
                        x_ *= 0.9;
                        y_ *= 0.9;

                        //通过你鼠标移动的距离来计算旋转的度数
                        roX -= y_ * 0.15;
                        roY += x_ * 0.15;

                        //旋转ul
                        oUl.style.transform = `translateZ(${trZ}px) rotateX(${roX}deg) rotateY(${roY}deg)`;

                        if (Math.abs(x_) < 0.1 && Math.abs(y_) < 0.1) return;

                        requestAnimationFrame(m);


                    }

                    if (new Date - moveTime < 100) {
                        requestAnimationFrame(m)
                    }

                }
            }

            //滚轮滚动改变z轴
            !function (fn) {
                //滚轮兼容
                if (document.onmousewheel === undefined) {
                    //这里火狐浏览器执行
                    document.addEventListener('DOMMouseScroll', function (e) {
                        let d = - e.detail / 3;
                        fn(d);
                    }.false)
                } else {
                    //主流浏览器
                    document.onmousewheel = function (e) {
                        let d = - e.wheelDelta / 120;
                        fn(d);
                    }

                }
            }(function (d) {
                trZ += d * 100;
                oUl.style.transform = `translateZ(${trZ}px) rotateX(${roX}deg) rotateY(${roY}deg)`;

            })

        })();


        //右下角点击事件
        (function () {
            //获取所有的按钮
            let aBtn = document.getElementById('btn').getElementsByTagName('li');
            let arr = [Table, Sphere, Helix, Grid];
            for (let i = 0; i < aBtn.length; i++) {
                aBtn[i].onclick = arr[i];
            }

        })()

        //元素周期表
        function Table() {
            if (Table.arr) {
                for (let i = 0; i < length; i++) {
                    aLi[i].style.transform = Table.arr[i];
                }
            } else {
                Table.arr = [];
                //定义变量
                let n = Math.ceil(length / 18) + 2;        //计算li要排多少行
                let midY = n / 2 - 0.5;         //现在有9行,ul所在的位置在第四行
                let midX = 18 / 2 - 0.5;          //计算垂直方向上ul所在的x位置

                //定义每个li之间的间距
                let disX = 170,
                    disY = 210;

                let arr = [
                    { x: 0, y: 0 },
                    { x: 17, y: 0 },
                    { x: 0, y: 1 },
                    { x: 1, y: 1 },
                    { x: 12, y: 1 },
                    { x: 13, y: 1 },
                    { x: 14, y: 1 },
                    { x: 15, y: 1 },
                    { x: 16, y: 1 },
                    { x: 17, y: 1 },
                    { x: 0, y: 2 },
                    { x: 1, y: 2 },
                    { x: 12, y: 2 },
                    { x: 13, y: 2 },
                    { x: 14, y: 2 },
                    { x: 15, y: 2 },
                    { x: 16, y: 2 },
                    { x: 17, y: 2 },

                ];

                //循环计算li的位置
                for (let i = 0; i < length; i++) {
                    let x, y;
                    if (i < 18) {
                        x = arr[i].x;
                        y = arr[i].y;
                    } else {
                        x = i % 18;
                        y = Math.floor(i / 18) + 2;
                    }
                    //设置li的位置
                    let val = `translate3D(${(x - midX) * disX}px,${(y - midY) * disY}px,0px)`;
                    Table.arr[i] = val
                    aLi[i].style.transform = val;
                }
            }

        }

        //球面布局
        function Sphere() {
            if (Sphere.arr) {
                for (let i = 0; i < length; i++) {
                    aLi[i].style.transform = Sphere.arr[i];
                }
            } else {
                Sphere.arr = [];
                //定义arr确定球面一共有多少层,以及每层有多少个li
                let arr = [1, 3, 7, 9, 11, 14, 21, 16, 12, 10, 9, 7, 4, 1];
                arrlen = arr.length;
                xDeg = 180 / (arrlen - 1);
                //循环遍历所有的li
                for (let i = 0; i < length; i++) {
                    //定义变量来保存此时的li是球面上的第几层,已经当前层的第几个
                    let numC = 0,   //计算当前li是第几层
                        numG = 0,  //处于当前层的第几个
                        arrSum = 0;     //当目前层为止一共有多少个i

                    //for循环判断此时的i是第几层第几个
                    for (let j = 0; j < arrlen; j++) {
                        arrSum += arr[j];

                        //判断i是第几层第几个
                        if (arrSum > i) {
                            numC = j;
                            numG = arr[j] - (arrSum - i);
                            break;
                        }

                    }

                    //根据当前层数求出当前层每一liy轴旋转度数
                    let yDeg = 360 / arr[numC];
                    //设置li旋转

                    let val = ` rotateY(${(numG + 1.3) * yDeg}deg)  rotateX(${90 - numC * xDeg}deg) translateZ(800px)`
                    Sphere.arr[i] = val;
                    aLi[i].style.transform = val;
                }

            }

        }


        //螺旋式布局
        function Helix() {
            if (Helix.arr) {
                for (let i = 0; i < length; i++) {
                    aLi[i].style.transform = Helix.arr[i];
                }
            } else {
                Helix.arr = [];
                //定义环数
                let h = 3.7,
                    tY = 7,   //每个li上下错位
                    num = Math.round(length / h),     //确定每一圈多少个li
                    deg = 360 / num,         //计算每个li y轴旋转度数
                    mid = length / 2 - 0.5;        //找个中间值

                for (let i = 0; i < length; i++) {
                    let val = ` rotateY(${i * deg}deg)  translateY(${(i - mid) * tY}px) translateZ(800px)`
                    Helix.arr[i] = val;
                    aLi[i].style.transform = val;
                }
            }
        }


        //Grid
        function Grid() {

            if (Grid.arr) {
                //不是第一次点击
                for (let i = 0; i < length; i++) {
                    aLi[i].style.transform = Grid.arr[i];
                }
            } else {

                //第一次计算
                Grid.arr = [];
                let disX = 350,         //每个li水平(x)方向的间距     
                    disY = 350,         //每个li垂直(y)方向的间距
                    disZ = 350;         //每个li纵深(z)方向的间距

                //for循环每个li,计算每个li的x,y,z的值

                for (let i = 0, len = aLi.length; i < len; i++) {
                    let oLi = aLi[i];
                    let x = (oLi.x - 2) * disX,
                        y = (oLi.y - 2) * disY,
                        z = (oLi.z - 2) * disZ;


                    let val = `translate3D(${x}px,${y}px,${z}px)`;
                    Grid.arr[i] = val;
                    oLi.style.transform = val;

                }

            }




        }


    })();


}