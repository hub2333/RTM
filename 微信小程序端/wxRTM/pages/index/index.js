//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    predicate:'',
    nir:'',
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse){
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },
  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  },
  socket:function(){
    var that = this;
    wx.request({
      url: 'http://localhost:8080/RTM/linked',
      data:{
        parm:'requestlink'
      },
      success:function(res){
        that.setData({
          nir:res.data.parm

        })

      }

    })


  },
  usemodel:function(){
    var that = this;
    wx.request({
      url: 'http://localhost:8080/RTM/testModel',
      data: {
        
      },
      success: function (res) {
        console.log(res.data)
      }

    })


  },
  //测试websocket
  socket:function(){
    var that = this
    wx.connectSocket({
      url: 'ws://localhost:8080/RTM/websocket',
      // url:'http://eservicesit.prlife.com.cn:7001',
      data: {
        x: '12',
        y: '34'
      },
      header: {
        'content-type': 'application/json'
      },
      method: "GET",
      success: function (res) {
        console.log("创建连接成功");
        console.log(res.data)
        //do something
  
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
      that.setData({
        predicate: res.data
      })
      console.log('收到服务器内容：' + res.data)
    })
  },
  sendSocketMessage:function () {
    var msg = '发送数据'
    if(true) {
      wx.sendSocketMessage({
        data: msg
      })
    } else {
      socketMsgQueue.push(msg)
    }
  }
})
