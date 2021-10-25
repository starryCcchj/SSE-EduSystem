<template>
  <div class="register-container">
      <el-form :model="ruleForm2" :rules="rules2"
        status-icon
        label-position="left" 
        label-width="5px"
        class="register-page"
      >
        <h3 class="title">注册新账号</h3>
        <el-form-item prop="username">
                <el-input type="text" 
                    v-model="ruleForm2.username" 
                    auto-complete="off" 
                    placeholder="用户名"
                ></el-input>
            </el-form-item>
                <el-form-item prop="password">
                    <el-input type="password" 
                        v-model="ruleForm2.password" 
                        auto-complete="off" 
                        placeholder="密码"
                    ></el-input>
                </el-form-item>
            <el-form-item prop="email">
              <el-row :gutter="4">
              <el-col :span="16">
                <el-input type="email" 
                    v-model="ruleForm2.email" 
                    auto-complete="off" 
                    placeholder="电子邮箱"
                   
                ></el-input>
              </el-col>
              <el-col :span="5" >
                <el-button plain>发送验证码</el-button>
              </el-col>
              </el-row>
                </el-form-item>
                <el-form-item prop="verification">
              <el-form-item prop="verification">
                <el-input type="verification" 
                    v-model="ruleForm2.verification" 
                    auto-complete="off" 
                    placeholder="验证码"
                ></el-input>
              </el-form-item>
                </el-form-item>
                 <el-form-item style="width:100%;">
                <el-button type="primary" style="width:100%;" @click="Register" >确认注册</el-button>
            </el-form-item>
      </el-form>
  </div>
</template>

<script>
export default {
    name:'register',
    data(){
        return {
        
            ruleForm2: {
                username: '',
                password: '',
                email:'',
                verification:''
            },
            rules2: {
                username: [{min:4,max:10,required: true, message: '你的用户名长度应在4到10个字符之间', trigger: 'blur'}],
                password: [{min:8,max:20,required: true, message: '你的密码长度应该在8到20位之间', trigger: 'blur'}],
                email:[{required: true, message: '请输入邮箱地址',trigger: 'blur'}, {validator:function(rule,value,callback){
                   
                          if (value !== '') { 
                            // var reg=/^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
                            var reg=/^[A-Za-z0-9]+([_.][A-Za-z0-9]+)*@([A-Za-z0-9-]+\.)+[A-Za-z]{2,6}$/;
                              if(!reg.test(value)){
                                  callback(new Error('请输入有效的邮箱'));
                             }
                             else{}
                  }
    	      }}],
                verification:[{required: true, message: '请输入邮箱中接收到的验证码', trigger: 'blur'}]
            },
            checked: false
        }
    },
    methods: {
       Register()
       {
           alert("111");
       },
       
    },
   
}
</script>

<style>
.register-container {
    width: 100%;
    height: 100%;
}
.register-page {
    -webkit-border-radius: 5px;
    border-radius: 5px;
    margin: 180px auto;
    width: 350px;
    padding: 35px 35px 15px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
}
</style>