// pages/nirplot/nirplot.js
import * as echarts from '../../ec-canvas/echarts';
var app = getApp()
var option1 = {};
var chart1; //画板
var timer; //定时器
function initChart(canvas, width, height) {
   chart1 = echarts.init(canvas, null, {
    width: width,
    height: height
  });
  canvas.setChart(chart1);

  var option = option1;
  chart1.setOption(option);
  return chart1;
}


Page({

  /**
   * 页面的初始数据
   */
  data: {
    ec: {
      onInit: initChart
    },
    processdata:[],
    pttdata:[]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    //加载全局的数据
    var that = this;
    //
    


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
    
    this.countdown();
  
    
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
  countdown:function () {
    var that = this;
    timer = setTimeout(function () {
      console.log("----Countdown----");
      that.setData({
        pttdata: app.globalData.pttdata
      })
      option1 = {
        grid: {
          show: true
        },
        xAxis: {
          type: 'category'
        },
        yAxis: {
          type: 'value'
        },
        series: [{//
          data: that.data.pttdata,
          type: 'line',
          smooth: true
        }]
      };
      chart1.setOption(option1);
      that.countdown();
    }, 1000);
  }
})