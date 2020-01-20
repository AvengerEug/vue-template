<template>
  <div class="app-container">
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
    >
      <el-table-column align="center" label="ID" width="95">
        <template slot-scope="scope">
          {{ scope.$index }}
        </template>
      </el-table-column>
      <el-table-column label="Title">
        <template slot-scope="scope">
          {{ scope.row.title }}
        </template>
      </el-table-column>
      <el-table-column label="Author" width="110" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.author }}</span>
        </template>
      </el-table-column>
      <el-table-column label="Pageviews" width="110" align="center">
        <template slot-scope="scope">
          {{ scope.row.pageviews }}
        </template>
      </el-table-column>
      <el-table-column class-name="status-col" label="Status" width="110" align="center">
        <template slot-scope="scope">
          <el-tag :type="scope.row.status | statusFilter">{{ scope.row.status }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column align="center" prop="created_at" label="Display_time" width="200">
        <template slot-scope="scope">
          <i class="el-icon-time" />
          <span>{{ scope.row.display_time }}</span>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>

export default {
  filters: {
    statusFilter(status) {
      const statusMap = {
        published: 'success',
        draft: 'gray',
        deleted: 'danger'
      }
      return statusMap[status]
    }
  },
  data() {
    return {
      list: [],
      listLoading: true
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.listLoading = true
      this.list = [{"id":"520000198412312886","title":"Diys buwreanvd dond tnzwi hbz uespysm lxsejcl hvwbttmk jqi yve luljwi ldtyz oywq xsfp.","status":"draft","author":"name","display_time":"1996-01-15 08:37:36","pageviews":3091},{"id":"820000200509273730","title":"Pxondj kwtcuciqm tiknjxfdg zeoes nvig omyc lkqbeoifed odqso yrhdyfuth iomgg nvvfed vowjl wgdlwinrme ftpuyon bmjgpnh.","status":"draft","author":"name","display_time":"1993-12-24 14:58:50","pageviews":2043},{"id":"810000201012266773","title":"Qrdu vkg lalush vunkvvgs nwoqx hyi crow xzyzrkta ruzhhfhs ihyuj gvly txwkogml vuqokw tfronp koiiz.","status":"deleted","author":"name","display_time":"1973-02-19 04:25:22","pageviews":644},{"id":"15000019790111633X","title":"Lhtbzt cscno aqmpr euxwdptx ikoxut ujto ifgjzatj wkyyh sejia tbmagp ujglusxgjy jcejhrpu uue gddqjvz bssm.","status":"draft","author":"name","display_time":"2004-10-30 01:49:01","pageviews":1079},{"id":"510000197207160506","title":"Zhht tehuwiwie gxwnqh rjdpswoqcu swcyscyjh orelh tisp nnsqhh efvcenjri egdrhqc qtlonp xubppbgqms ffser.","status":"draft","author":"name","display_time":"1993-08-21 11:26:43","pageviews":1607},{"id":"15000020121031765X","title":"Liss tdkx vuma tcxovgbwgs ogx trudeedoz dfmwfwvn nhqaycpnuq ddpgxwn qtwysdxic dpqmvhdr fltjise vqqop djwk vbsfqdut cfvoftcw rmdvvdip ikgdcbhnqb ygx.","status":"draft","author":"name","display_time":"1995-05-12 21:43:14","pageviews":1235},{"id":"320000198506211288","title":"Fhttjck hhakb gcuf upequc alcigyhgf usixpikpdv nojmio puxf bcrpl hmfmvmdqc blivqcn.","status":"draft","author":"name","display_time":"2010-12-21 10:55:35","pageviews":2924},{"id":"330000197612134172","title":"Bynslh ytbsnbfykj xrbmbwatu ienmxns tsrm exwrjoypa wjxde xvdqqww uire ddwgvyovo mgqn tpevu djqbcf rwcjgsinip uwvt srn qdwzoyj xtyfq bridmip.","status":"draft","author":"name","display_time":"1983-07-01 16:53:16","pageviews":3921},{"id":"50000020170617642X","title":"Mtk yeegvqxna dequ polfohv bpsbc hfwe undejoq vfo wohebr pvmpv csucqe ilp fst qfkubku.","status":"draft","author":"name","display_time":"1981-01-29 21:03:02","pageviews":4600},{"id":"450000197004143662","title":"Ordewy cjbvpokf ipm wwippjex bhej cqpzfonp lfb gmpdqzs shdy yluhxqmd jncekz ppmqncv ihy fuwjstdp.","status":"draft","author":"name","display_time":"1991-02-21 03:05:48","pageviews":3531},{"id":"46000019720130181X","title":"Oary xvyjxmvve gisbcscvn zzgxu ttqhxbvhky wgzcxbckd pppkj dsltwjuiu vlwdtm ohhdot xlhcddf vhbg aylpgmfh voyubnpuwh olpuy iveunfdrms kmxz.","status":"published","author":"name","display_time":"1982-04-18 04:15:12","pageviews":3175},{"id":"460000198912316983","title":"Vhsf eftv pmdpoevvyn wpckqy wegjtrgpkq diztyo nit bexnm ssydkou glwsz nlzvh ytevemyoq ioeqgj jwtns.","status":"draft","author":"name","display_time":"2000-02-01 12:05:32","pageviews":730},{"id":"610000199309154978","title":"Ycumdsuet qrxpnodvq rivpuz adclteqbp nnqjg pagfapgb ucd xzlpsh utpv eyu ykkbmbsm.","status":"draft","author":"name","display_time":"2007-10-23 17:35:44","pageviews":1583},{"id":"42000019871229839X","title":"Cdugj vwgkjaq gxismy mqhdfjoo jkginjn jrulcsdp rlpotdpf lzphtl yfv zhereiywe yfahdr igkabftc cshxlxbeeq rrizoedpu cekhqjvp.","status":"published","author":"name","display_time":"1979-12-17 10:05:44","pageviews":3615},{"id":"440000198709252853","title":"Asbruid iklcmsgt bqelpr fdiqd ojyfhld yhdqnkmv gsoja yval notltpqd fnje hwiuexkx igwend ctiafk dyco gaxpqqc kiwxwesgk deiwft cirygwg.","status":"published","author":"name","display_time":"2002-01-06 13:32:06","pageviews":1953},{"id":"21000019730419597X","title":"Ocbdim cxhkbyx yrqd mgtokbe zmnculjsy rqdkzcua oypfq ffidum msnhqtslrn qzep ipdfj ywtkelqjl ukot ctcewd rixivts wgruy.","status":"published","author":"name","display_time":"1984-06-02 17:39:23","pageviews":3684},{"id":"430000198107033643","title":"Bui vlgdovavk ldbwl hyevm lwizqghrdd ndfjnr tpljvbgix ninbsti lrnqi lvkqhotq linvtgdh dcuuqft mlolhxec cxdhnzjn.","status":"draft","author":"name","display_time":"2010-06-18 23:02:38","pageviews":4962},{"id":"61000019900710502X","title":"Kndjiky lbdlpkmh xkyvl niqlsnbhtu stilrofly igux hbwwutx aulb rvfkkw eyurd bxnptuh pwczpnmsw plru bdnnet.","status":"deleted","author":"name","display_time":"2001-11-11 23:08:14","pageviews":1015},{"id":"320000200209115740","title":"Xatwxmilue slcywu yqmqgkkuqv jbflbylqty nnsbkjono nsixiuas rovyx pnpmxeuaql vxlh pvpjbc.","status":"draft","author":"name","display_time":"2001-04-01 18:17:49","pageviews":3295},{"id":"42000019870311355X","title":"Xdx kseiop uwmwzz giqnglv nhkhdnehp vcxtvrt hekpy prxg xile hdhpbvstf xpbkiqe dbiupdzy qwlfacka kwzr iumnmi fhncffinj wwxwhov qncwrvfm nqucsqnn.","status":"draft","author":"name","display_time":"1977-02-16 04:54:08","pageviews":612},{"id":"820000200412281670","title":"Edokdjmyb yripykbdqx qvmbnvtcpw avespwonx mngm dnqapiqla zbvlrnk mzgvdvq mjqjgs nkbdl yhrwxhjs rxxn gxttypoyp grvvnmjdt rojcrfv uatgv jtjz yxtueh xxoeimg.","status":"deleted","author":"name","display_time":"1996-06-23 20:04:31","pageviews":743},{"id":"330000201707102236","title":"Uwbksky erergfdv kebiiwd glku bxsk qbwiu tkpip pfte ksnegt hurq riuhn gwbus tidispny jduywdy urrm gfjnzrpf lszgg.","status":"deleted","author":"name","display_time":"2008-12-26 02:34:30","pageviews":4305},{"id":"420000199602032704","title":"Mljempfcs nujyvwyj cmnul almsuoeel ddrqi ojpknrxnv bygluu vxjcengtf ymv fogrcs elykcdix mxk kfbyrwzb hxmjpeff kpjrpgg bmqwcimbe pefg.","status":"published","author":"name","display_time":"1983-05-07 13:28:44","pageviews":1265},{"id":"43000020150618577X","title":"Uknsipqk pvld pqnqg dkwipgcsxc lynp imlrny jickhmia jwgsobxhb bbciotuvw nbcy rkspgyt qejywnquu bxsjhno twserjgoi wvbzqrwwb dhky.","status":"draft","author":"name","display_time":"2015-01-08 08:56:09","pageviews":4211},{"id":"45000019740403705X","title":"Jnemidr eotemvuz nryf dsd dnbv fycqzeglre nqklevrdb znny foupqy zhijqct.","status":"draft","author":"name","display_time":"1973-01-17 01:22:45","pageviews":4620},{"id":"540000200411036879","title":"Ximvl etrzf mkroanvy nhfrw eqjof ahvm posgzwlb dgnvyhxzip ajtqxy opuwefgflt wfsnrzfz.","status":"published","author":"name","display_time":"1982-01-16 15:53:43","pageviews":3636},{"id":"450000199807073361","title":"Chkarr qewqs gpylxzjrx qgturpkl dcefygong wrchdohz faisuokdt hhle oinyxtg phurtdq dhefpytc fcpcfkju gxbojnmibb kgpt jcmfevsd.","status":"draft","author":"name","display_time":"1972-01-31 09:50:32","pageviews":2070},{"id":"150000197112186124","title":"Vxeu choou wftxxcgyr wqjgidx nylmdqpye wqckhn yfwugfe fvnjlugpsv ndjignvqpp zxxocjhjo wiile clvritu tjpfkp bnsd.","status":"published","author":"name","display_time":"2007-01-04 00:10:52","pageviews":2402},{"id":"120000200301218358","title":"Inyyznhqbh mjgiq wirj zmzpimo lbciva xyrmtu tfkdwcke voexmrdjd ytvfjmpy uopwl okmdmwc joyohes ylruq zfyhnzmqdk kgrshdyxxl szgma hyq hyt.","status":"deleted","author":"name","display_time":"1970-02-18 01:17:11","pageviews":817},{"id":"15000020170608575X","title":"Kwbxustyo huflygqyl dusqpnngju sjcvblf xcoxtmp ooddug voxcmxxm fsp yyhb sukorc ewrxsjqva muzsl njuqpwcy trclsv ejpx ssusjirbr ilrcj.","status":"deleted","author":"name","display_time":"1999-07-31 18:14:42","pageviews":568}]
      this.listLoading = false
    }
  }
}
</script>
