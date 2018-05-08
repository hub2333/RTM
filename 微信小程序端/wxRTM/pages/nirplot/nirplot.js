// pages/nirplot/nirplot.js
import * as echarts from '../../ec-canvas/echarts';
var chart;
var option1 = {
  backgroundColor: "#fff",
  color: ["#37A2DA", "#67E0E3", "#9FE6B8"],

  tooltip: {
    trigger: 'axis'
  },
  legend: {

    data: ['A商品', 'B商品', 'C商品']
  },
  grid: {
    containLabel: true
  },

  xAxis: {
    type: 'category',
    boundaryGap: false,
    data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
  },
  yAxis: {
    x: 'center',
    type: 'value'
  },
  series: [{
    name: 'A商品',
    type: 'line',
    smooth: true,
    data: [18, 36, 65, 30, 78, 40, 33]
  }, {
    name: 'B商品',
    type: 'line',
    smooth: true,
    data: [12, 50, 51, 35, 70, 30, 20]
  }, {
    name: 'C商品',
    type: 'line',
    smooth: true,
    data: [10, 30, 31, 50, 40, 20, 10]
  }]
}
function initChart(canvas, width, height) {
  chart = echarts.init(canvas, null, {
    width: width,
    height: height
  });
  canvas.setChart(chart);

  var option = option1;
  chart.setOption(option);
  return chart;
}


Page({

  /**
   * 页面的初始数据
   */
  data: {
    nirfile:'',
    ec: {
      onInit: initChart
    },
    nirdata:[],
    option:''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    var nirfile = JSON.parse(options.nirfile);
    this.setData({
      nirfile: nirfile
    })
    var nirdata = that.data.nirfile.nir.split(",");
    var nirwave = that.data.nirfile.nirWave.split(",");
    //
    option1 = {
      grid:{
        show:true
      },
      xAxis: {
        type: 'category',
        data: nirwave
      },
      yAxis: {
        type: 'value'
      },
      series: [{
        data: nirdata,
        type: 'line',
        smooth: true
      }]
    };
    chart.setOption(option1); 
    // this.setData({
    //   // nirdata: nirdata,
    //   // option: option
    // })

    chart.dispatchAction({
      type: 'brush',
      areas: [
        {
          brushType: 'lineX',
          coordRange: ['5000', '8000'],
          xAxisIndex: 0
        }
      ]
    });


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
  
  }
})