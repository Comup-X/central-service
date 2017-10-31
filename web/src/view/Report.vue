<template>
    <div style="overflow: auto">
        <el-collapse accordion>
            <el-collapse-item title="门票线下收入" name="1">
                <el-input v-model="xxqp" value="number">
                    <template slot="prepend"><span class="color-chocolate">全票</span></template>
                </el-input>
                <el-input v-model="xxbp" value="number">
                    <template slot="prepend"><span class="color-chocolate">半票</span></template>
                </el-input>
                <el-input v-model="xxtp" value="number">
                    <template slot="prepend"><span class="color-chocolate">套票</span></template>
                </el-input>
            </el-collapse-item>
            <el-collapse-item title="门票线上收入" name="2">
                <el-input v-model="jyspxt" value="number">
                    <template slot="prepend"><span class="color-chocolate">聚赢售票系统</span></template>
                </el-input>
                <el-input v-model="qtpwxtqp" value="number">
                    <template slot="prepend"><span class="color-chocolate">前台票务系统全票</span></template>
                </el-input>
                <el-input v-model="qtpwxtbp" value="number">
                    <template slot="prepend"><span class="color-chocolate">前台票务系统半票</span></template>
                </el-input>
                <el-input v-model="qtpwxttp" value="number">
                    <template slot="prepend"><span class="color-chocolate">前台票务系统团票</span></template>
                </el-input>
                <el-input v-model="ltotaxs" value="number">
                    <template slot="prepend"><span class="color-chocolate">旅投OTA销售</span></template>
                </el-input>
            </el-collapse-item>
            <el-collapse-item title="停车场收入" name="3">
                <el-input v-model="tcc1" value="number">
                    <template slot="prepend"><span class="color-chocolate">1#停车场</span></template>
                </el-input>
                <el-input v-model="tcc2" value="number">
                    <template slot="prepend"><span class="color-chocolate">2#停车场</span></template>
                </el-input>
                <el-input v-model="tcc3" value="number">
                    <template slot="prepend"><span class="color-chocolate">3#停车场</span></template>
                </el-input>
            </el-collapse-item>
            <el-collapse-item title="景区进系统流水" name="4">
                <el-input v-model="jqjxtls" value="number">
                    <template slot="prepend"><span class="color-chocolate">景区进系统流水</span></template>
                </el-input>
            </el-collapse-item>
            <el-collapse-item title="自营场馆收入" name="5">
                <!--吴文书院-->
                <el-input v-model="wwsymp" value="number">
                    <template slot="prepend"><span class="color-chocolate">吴文书院门票收入</span></template>
                </el-input>
                <el-input v-model="wwsyzh" value="number">
                    <template slot="prepend"><span class="color-chocolate">吴文书院字画收入</span></template>
                </el-input>
                <el-input v-model="wwsycs" value="number">
                    <template slot="prepend"><span class="color-chocolate">吴文书院茶水收入</span></template>
                </el-input>
                <!--皇后舞厅-->
                <el-input v-model="hhwtmp" value="number">
                    <template slot="prepend"><span class="color-chocolate">皇后舞厅门票收入</span></template>
                </el-input>
                <el-input v-model="hhwtjsxc" value="number">
                    <template slot="prepend"><span class="color-chocolate">皇后舞厅酒水小吃收入</span></template>
                </el-input>
                <!--大戏台-->
                <el-input v-model="dxt" value="number">
                    <template slot="prepend"><span class="color-chocolate">大戏台收入</span></template>
                </el-input>
                <!--国泰戏院-->
                <el-input v-model="gtxymp" value="number">
                    <template slot="prepend"><span class="color-chocolate">国泰戏院门票现金收入</span></template>
                </el-input>
                <el-input v-model="gtxywx" value="number">
                    <template slot="prepend"><span class="color-chocolate">国泰戏院微信收入</span></template>
                </el-input>
                <el-input v-model="gtxycd" value="number">
                    <template slot="prepend"><span class="color-chocolate">国泰戏院场地收入</span></template>
                </el-input>
                <!--总统府-->
                <el-input v-model="ztfmp" value="number">
                    <template slot="prepend"><span class="color-chocolate">总统府门票</span></template>
                </el-input>
                <el-input v-model="ztfhbc" value="number">
                    <template slot="prepend"><span class="color-chocolate">总统府黄包车</span></template>
                </el-input>
                <el-input v-model="ztffzzx" value="number">
                    <template slot="prepend"><span class="color-chocolate">总统府服装照相</span></template>
                </el-input>
                <!--大食代-->
                <el-input v-model="dsd" value="number">
                    <template slot="prepend"><span class="color-chocolate">大食代收入</span></template>
                </el-input>
                <!--前台充值-->
                <el-input v-model="qtczxj" value="number">
                    <template slot="prepend"><span class="color-chocolate">前台充值现金</span></template>
                </el-input>
                <el-input v-model="qtczxssm" value="number">
                    <template slot="prepend"><span class="color-chocolate">前台充值线上扫码</span></template>
                </el-input>
                <el-input v-model="qtczposj" value="number">
                    <template slot="prepend"><span class="color-chocolate">前台充值POS机</span></template>
                </el-input>
            </el-collapse-item>
            <el-collapse-item title="线下门票销售情况" name="6">
                <el-input v-model="xxqpxszs" value="number">
                    <template slot="prepend"><span class="color-chocolate">线下门票全票销售张数</span></template>
                </el-input>
                <el-input v-model="xxqpxsrs" value="number">
                    <template slot="prepend"><span class="color-chocolate">线下门票全票销售人数</span></template>
                </el-input>
                <el-input v-model="xxbpxszs" value="number">
                    <template slot="prepend"><span class="color-chocolate">线下门票半票销售张数</span></template>
                </el-input>
                <el-input v-model="xxbpxsrs" value="number">
                    <template slot="prepend"><span class="color-chocolate">线下门票半票销售人数</span></template>
                </el-input>
                <el-input v-model="xxtpxszs" value="number">
                    <template slot="prepend"><span class="color-chocolate">线下门票团票销售张数</span></template>
                </el-input>
                <el-input v-model="xxtp_xszs" value="number">
                    <template slot="prepend"><span class="color-chocolate">线下门票套票销售张数</span></template>
                </el-input>
            </el-collapse-item>
            <el-collapse-item title="线上门票销售情况" name="7">
                <el-input v-model="xsjyspxtxszs" value="number">
                    <template slot="prepend"><span class="color-chocolate">线上聚赢售票系统销售张数</span></template>
                </el-input>
                <el-input v-model="xsqtpwxtspqpzs" value="number">
                    <template slot="prepend"><span class="color-chocolate">线上前台票务系统售票全票张数</span></template>
                </el-input>
                <el-input v-model="xsqtpwxtspqprs" value="number">
                    <template slot="prepend"><span class="color-chocolate">线上前台票务系统售票全票人数</span></template>
                </el-input>
                <el-input v-model="xsqtpwxtspbpzs" value="number">
                    <template slot="prepend"><span class="color-chocolate">线上前台票务系统售票半票张数</span></template>
                </el-input>
                <el-input v-model="xsqtpwxtspbprs" value="number">
                    <template slot="prepend"><span class="color-chocolate">线上前台票务系统售票半票人数</span></template>
                </el-input>
                <el-input v-model="ota17" value="number">
                    <template slot="prepend"><span class="color-chocolate">线上旅投OTA17销售张数</span></template>
                </el-input>
                <el-input v-model="ota18" value="number">
                    <template slot="prepend"><span class="color-chocolate">线上旅投OTA18销售张数</span></template>
                </el-input>
                <el-input v-model="ota33" value="number">
                    <template slot="prepend"><span class="color-chocolate">线上旅投OTA33.3销售张数</span></template>
                </el-input>
                <el-input v-model="ota49" value="number">
                    <template slot="prepend"><span class="color-chocolate">线上旅投OTA49.5销售张数</span></template>
                </el-input>
            </el-collapse-item>
            <el-input v-model="xyyh" value="number">
                <template slot="prepend"><span class="color-chocolate">兴业银行</span></template>
            </el-input>
            <!--结果-->
            <p>计算结果：</p>
            <span>{{result}}</span>
        </el-collapse>
    </div>
</template>

<script>
    /**
     *    10月13日（八月二十四日），当日总计资金流水33117.40元（含流水金额，前台充值金额），售票总人数945人。应确认收入20832.50元（不含现金流水充值部分）.
     *    其中：
     *    1、门票收入元{17312.70}元，分别是门票线下收入:{14146}元（其中线下全票#11900元，半票#1270元，套票#0元，团票#976元）
     *                                  和线上收入:{3166.70}元（聚赢售票系统20元/张销售#0元；前台票务系统全票#2700元，半票#0元；团票#0元；旅投OTA销售#466.70元）；
     *    2、停车场收入:2000元（其中：1#停车场0元，2#停车场0元，3#停车场2000元）；
     *    3、景区进系统流水应确认收入1375.80元（抽10%收入，含大食代，总统府流水收入）；
     *    4、自营场馆收入0元，分别是：
     *                      吴文书院：0元（其中门票收入0元，字画净收入0元，茶水收入0元），
     *                      皇后舞厅净收入0元（其中门票流水收入0元，酒水和小吃消费0元），
     *                      大戏台净收入0元，
     *                      国泰戏院净收入0元（其中：门票收入现金0元，微信0元，场地费0元）。
     *                   另:总统府流水720元（门票180元，黄包车540元，服装照相0元），
     *                      大食代流水0元，
     *                      前台充值流水6220元（其中现金6220元，线上扫码充值0元，POS机0元）。
     *    5、门票销售419张945人，
     *                  其中线下全票销售219张595人，
     *                  半票销售69张127人，
     *                  团票销售61张（其中16元/张有61张），
     *                  套票销售0张；
     *                  线上销售70张162人
     *                  （聚赢售票系统20元/张销售0张，
     *                    前台票务系统售票全票49张135人，半票0张0人；
     *                    旅投OTA17元/张检票4张4人，18元/张检票12张12人，33.30元/张双人票检票4张8人，49.5元/张三人票检票1张3人）。
     *                    今日售票无差异。
     */

    export default {
        data() {
            return {
                xxqp: '',
                xxbp: '',
                xxtp: '',

                jyspxt: '',
                qtpwxtqp: '',
                qtpwxtbp: '',
                qtpwxttp: '',
                ltotaxs: '',

                tcc1: '',
                tcc2: '',
                tcc3: '',

                jqjxtls: '',

                wwsymp: '',
                wwsyzh: '',
                wwsycs: '',

                hhwtmp: '',
                hhwtjsxc: '',

                dxt: '',

                gtxymp: '',
                gtxywx: '',
                gtxycd: '',

                ztfmp: '',
                ztfhbc: '',
                ztffzzx: '',

                dsd: '',

                qtczxj: '',
                qtczxssm: '',
                qtczposj: '',

                xxqpxszs: '',
                xxqpxsrs: '',
                xxbpxszs: '',
                xxbpxsrs: '',
                xxtpxszs: '',
                xxtp_xszs: '',

                xsjyspxtxszs: '',
                xsqtpwxtspqpzs: '',
                xsqtpwxtspqprs: '',
                xsqtpwxtspbpzs: '',
                xsqtpwxtspbprs: '',
                ota17: '',
                ota18: '',
                ota33: '',
                ota49: '',

                xyyh: '',
            }
        },
        computed: {
            mp: function () {
                //门票收入
            },
            mpxssr: function () {
                //门票线上收入
                return Number(this.jyspxt) + Number(this.qtpwxtqp) + Number(this.qtpwxtbp) + Number(this.qtpwxttp) + Number(this.ltotaxs);
            },
            mpxxsr: function () {
                //门票线下收入
                return Number(this.xxqp) + Number(this.xxbp) + Number(this.xxtp) + 16 * Number(this.xxtpxszs);
            },
            mpsr: function () {
                return this.mpxxsr + this.mpxssr;
            },
            tccZsr: function () {
                return Number(this.tcc1) + Number(this.tcc2) + Number(this.tcc3);
            },
            jqjxtlsSr: function () {
                return Number(this.jqjxtls) / 10.0
            },
            wwsyZsr: function () {
                return Number(this.wwsymp) + Number(this.wwsycs) + Number(this.wwsyzh);
            },
            hhwtZsr: function () {
                return Number(this.hhwtmp) + Number(this.hhwtjsxc)
            },
            gtxyZsr: function () {
                return Number(this.gtxymp) + Number(this.gtxywx) + Number(this.gtxycd);
            },
            ztfZsr: function () {
                return Number(this.ztfmp) + Number(this.ztfhbc) + Number(this.ztffzzx);
            },
            qtczZsr: function () {
                return Number(this.qtczxj) + Number(this.qtczxssm) + Number(this.qtczposj);
            },


            zycsZsr: function () {
                return Number(this.wwsyZsr) + Number(this.hhwtZsr) + Number(this.dxt) + Number(this.gtxyZsr);
            },
            drzjzjls: function () {
                return Number(this.mpsr) + Number(this.tccZsr) + Number(this.zycsZsr) + Number(this.ztfZsr) + Number(this.dsd) + Number(this.qtczxj) + Number(this.xyyh);
            },
            yqrsr: function () {
                return Number(this.mpsr) + Number(this.tccZsr) + Number(this.jqjxtlsSr) + Number(this.zycsZsr) + (Number(this.ztfmp) * 0.5)
                    + (Number(this.ztfhbc) * 0.1) + (Number(this.ztffzzx) * 0.1);
            },
            xxtp_: function () {
                return Number(this.xxtpxszs) * 16
            },
            mpxsZrs: function () {
                return Number(this.xxqpxsrs) + Number(this.xxbpxsrs) + Number(this.xxtpxszs) + Number(this.xxtp_xszs) + Number(this.xsxszsZrs);
            },
            mpxsZzs: function () {
                return Number(this.xxqpxszs) + Number(this.xxbpxszs) + +Number(this.xxtpxszs) + Number(this.xxtp_xszs) + Number(this.xsxszsZzs);
            },
            xsxszsZzs: function () {
                return Number(this.xsjyspxtxszs) + Number(this.xsqtpwxtspqpzs) + Number(this.xsqtpwxtspbpzs) + Number(this.ota17) + Number(this.ota18) + Number(this.ota33) + Number(this.ota49);
            },
            xsxszsZrs: function () {
                return Number(this.xsjyspxtxszs) + Number(this.xsqtpwxtspqprs) + Number(this.xsqtpwxtspbprs) + Number(this.ota17) + Number(this.ota18) + (Number(this.ota33) * 2) + (Number(this.ota49) * 3);
            },

            result: function () {
                return "写日期，当日总计资金流水" + this.drzjzjls + "元（含流水金额，前台充值金额），售票总人数" + this.mpxsZrs + "人。应确认收入" + this.yqrsr + "元（不含现金流水充值部分）.\n" +
                    "        其中：\n" +
                    "        1、门票收入元" + this.mpsr + "元，分别是门票线下收入:" + this.mpxxsr + "元（其中线下全票" + this.xxqp + "元，半票" + this.xxbp + "元，套票" + this.xxtp + "元，团票" + this.xxtp_ + "元）\n" +
                    "                                      和线上收入:" + this.mpxssr + "元（聚赢售票系统20元/张销售" + this.jyspxt + "元；前台票务系统全票" + this.qtpwxtqp + "元，半票" + this.qtpwxtbp + "元；团票" + this.qtpwxttp + "元；旅投OTA销售" + this.ltotaxs + "元）；\n" +
                    "        2、停车场收入:" + this.tccZsr + "元（其中：1#停车场" + this.tcc1 + "元，2#停车场" + this.tcc2 + "元，3#停车场" + this.tcc3 + "元）；\n" +
                    "        3、景区进系统流水应确认收入" + this.jqjxtlsSr + "元（抽10%收入，含大食代，总统府流水收入）；\n" +
                    "        4、自营场馆收入" + this.zycsZsr + "元，分别是：\n" +
                    "                          吴文书院：" + this.wwsyZsr + "元（其中门票收入" + this.wwsymp + "元，字画净收入" + this.wwsyzh + "元，茶水收入" + this.wwsycs + "元），\n" +
                    "                          皇后舞厅净收入" + this.hhwtZsr + "元（其中门票流水收入" + this.hhwtmp + "元，酒水和小吃消费" + this.hhwtjsxc + "元），\n" +
                    "                          大戏台净收入" + this.dxt + "元，\n" +
                    "                          国泰戏院净收入" + this.gtxyZsr + "元（其中：门票收入现金" + this.gtxymp + "元，微信" + this.gtxywx + "元，场地费" + this.gtxycd + "元）。\n" +
                    "                       另:总统府流水" + this.ztfZsr + "元（门票" + this.ztfmp + "元，黄包车" + this.ztfhbc + "元，服装照相" + this.ztffzzx + "元），\n" +
                    "                          大食代流水" + this.dsd + "元，\n" +
                    "                          前台充值流水" + this.qtczZsr + "元（其中现金" + this.qtczxj + "元，线上扫码充值" + this.qtczxssm + "元，POS机" + this.qtczposj + "元）。\n" +
                    "        5、门票销售" + this.mpxsZzs + "张" + this.mpxsZrs + "人，\n" +
                    "                      其中线下全票销售" + this.xxqpxszs + "张" + this.xxqpxsrs + "人，\n" +
                    "                      半票销售" + this.xxbpxszs + "张" + this.xxbpxsrs + "人，\n" +
                    "                      团票销售" + this.xxtpxszs + "张（其中16元/张有" + this.xxtpxszs + "张），\n" +
                    "                      套票销售" + this.xxtp_xszs + "张；\n" +
                    "                      线上销售" + this.xsxszsZzs + "张" + this.xsxszsZrs + "人\n" +
                    "                      （聚赢售票系统20元/张销售" + this.xsjyspxtxszs + "张，\n" +
                    "                        前台票务系统售票全票" + this.xsqtpwxtspqpzs + "张" + this.xsqtpwxtspqprs + "人，半票" + this.xsqtpwxtspbpzs + "张" + this.xsqtpwxtspbprs + "人；\n" +
                    "                        旅投OTA17元/张检票" + this.ota17 + "张" + this.ota17 + "人，18元/张检票" + this.ota18 + "张" + this.ota18 + "人，33.30元/张双人票检票" + this.ota33 + "张" + Number(this.ota33) * 2 + "人，49.5元/张三人票检票" + this.ota49 + "张" + Number(this.ota49) * 3 + "人）。\n" +
                    "                        今日售票无差异。"
//                `
//                写日期，当日总计资金流水33117.40元（含流水金额，前台充值金额），售票总人数945人。应确认收入20832.50元（不含现金流水充值部分）.
//其中：
//1、门票收入元{17312.70}元，分别是门票线下收入:${this.mpxxsr}元（其中线下全票${this.xxqp}元，半票${this.xxbp}元，套票${this.xxtp}元，团票${this.xxtp_}元）
//                              和线上收入:{3166.70}元（聚赢售票系统20元/张销售#0元；前台票务系统全票#2700元，半票#0元；团票#0元；旅投OTA销售#466.70元）；
//2、停车场收入:2000元（其中：1#停车场0元，2#停车场0元，3#停车场2000元）；
//3、景区进系统流水应确认收入1375.80元（抽10%收入，含大食代，总统府流水收入）；
//4、自营场馆收入0元，分别是：
//                  吴文书院：0元（其中门票收入0元，字画净收入0元，茶水收入0元），
//                  皇后舞厅净收入0元（其中门票流水收入0元，酒水和小吃消费0元），
//                  大戏台净收入0元，国泰戏院净收入0元（其中：门票收入现金0元，微信0元，场地费0元）。
//               另:总统府流水720元（门票180元，黄包车540元，服装照相0元），
//                  大食代流水0元，
//                  前台充值流水6220元（其中现金6220元，线上扫码充值0元，POS机0元）。
//5、门票销售419张945人，
//              其中线下全票销售219张595人，
//              半票销售69张127人，
//              团票销售61张（其中16元/张有61张），
//              套票销售0张；
//              线上销售70张162人
//              （聚赢售票系统20元/张销售0张，
//                前台票务系统售票全票49张135人，半票0张0人；
//                旅投OTA17元/张检票4张4人，18元/张检票12张12人，33.30元/张双人票检票4张8人，49.5元/张三人票检票1张3人）。
//                今日售票无差异。
//                `;


            }
        },
        methods: {}
    }
</script>

<style type="less">
    .color-chocolate {
        color: chocolate;
    }
</style>