// pages/main/main.js
var processdatatemp=[]
var app = getApp()
var count = 0;
Page({

  /**
   * 页面的初始数据
   */
  data: {
    isChecked: false,
    processdata:[],
    reverse_processdata:[]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    //需要显示的是倒序数据
    var that = this;
    this.setData({
      reverse_processdata: that.data.processdata.reverse()
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  },
  // //开启websocket
  // openSocket:function(){
  //   var that = this
  //   wx.connectSocket({
  //     url: 'ws://localhost:8080/RTM/websocket',
  //     data: {
  //     },
  //     header: {
  //       'content-type': 'application/json'
  //     },
  //     method: "GET",
  //     success: function (res) {
  //       console.log("创建连接成功");
  //     },
  //     fail: function (res) {
  //       console.log("创建连接失败,原因因::" + res.errMsg);
  //     },
  //     complete: function () {
  //       console.log("创建连接complete");
  //     }
  //   })

  //   //监听
  //   wx.onSocketMessage(function (res) {
  //     console.log('收到服务器内容：' + res.data.predict)
  //     // var temp1 = 
  //     processdatatemp.push(JSON.parse(res.data))
  //     that.setData({
  //       processdata: processdatatemp
  //     })
  //     console.log("1")
  //     that.setData({
  //       reverse_processdata: that.data.processdata.reverse()
  //     })
  //     console.log("2")
  //     console.log("添加到全局：" + res.data.predict)
  //     //
  //     app.globalData.processdata = app.globalData.processdata.push(res.data.predict);

  //   })

  // },
  changeSwitch:function(){
    console.log("状态改变")
    var that = this
    if (that.data.isChecked==false){//表示需要开启
      wx.connectSocket({
        url: 'ws://127.0.0.1:8080/RTM/websocket',
        data: {
        },
        header: {
          'content-type': 'application/json'
        },
        method: "GET",
        success: function (res) {
          console.log("创建连接成功");
          that.setData({
            isChecked: !that.data.isChecked
          })
        },
        fail: function (res) {
          console.log("创建连接失败,原因因::" + res.errMsg);
        },
        complete: function () {
          console.log("创建连接complete");
        }
      })

      //监听
      wx.onSocketMessage(function (res) {
        count = count +1;
        console.log("计数：" + count)
        // console.log('收到服务器内容：' + res.data.predict)
        // 
        var temp0 =  JSON.parse(res.data);
        processdatatemp.push(temp0)
        that.setData({
          processdata: processdatatemp
        })
        that.setData({
          reverse_processdata: that.data.processdata.reverse()
        })
        console.log("全局：" + app.globalData.pttdata)
        app.globalData.pttdata.push(temp0.predict);

      })
    }else{//否则要关闭
        wx.closeSocket()
        //并清空数据
        processdatatemp = []
        that.setData({
          isChecked: !that.data.isChecked,
          reverse_processdata:[],
          processdata:[]
        })
        app.globalData.pttdata = [];
    }
    
    
  
    
  },
  //跳转到具体的光谱曲线
  gotonir:function(opt){
    var that = this
    var index = opt.currentTarget.dataset.index
    console.log("index:" + index)
    //待传递参数转成json字符串
    var nirfile = JSON.stringify(that.data.reverse_processdata[index]);
    wx.navigateTo({
      url: '../nirplot/nirplot?nirfile=' + nirfile,
    })


  }

})