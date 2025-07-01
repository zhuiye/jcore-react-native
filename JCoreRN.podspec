require 'json'
pjson = JSON.parse(File.read('package.json'))

fabric_enabled = ENV['RCT_NEW_ARCH_ENABLED'] == '1'



Pod::Spec.new do |s|

  s.name            = "JCoreRN"
  s.version         = pjson["version"]
  s.homepage        = pjson["homepage"]
  s.summary         = pjson["description"]
  s.license         = pjson["license"]
  s.author          = pjson["author"]
  
  s.ios.deployment_target = '7.0'

  s.source             = { :git => "https://github.com/jpush/jcore-react-native.git", :tag => "#{s.version}" }
  s.source_files       = 'ios/RCTJCoreModule/*.{h,m}'
  s.preserve_paths     = "**/*.js"
  s.vendored_frameworks = "ios/RCTJCoreModule/*.xcframework"
 	s.libraries       = 'z','resolv', 'sqlite3', 'c++.1'
  
  if fabric_enabled
    # Use install_modules_dependencies helper to install the dependencies if React Native version >=0.71.0.
    # See https://github.com/facebook/react-native/blob/febf6b7f33fdb4904669f99d795eba4c0f95d7bf/scripts/cocoapods/new_architecture.rb#L79.
    if respond_to?(:install_modules_dependencies, true)
      install_modules_dependencies(s)
    else
      # just for backward compatibility: if React Native version <= 0.70.x
      s.compiler_flags = "-DFOLLY_NO_CONFIG -DFOLLY_MOBILE=1 -DFOLLY_USE_LIBCPP=1 -Wno-comma -Wno-shorten-64-to-32 -DRCT_NEW_ARCH_ENABLED=1"
      s.pod_target_xcconfig    = {
        "HEADER_SEARCH_PATHS" => "\"$(PODS_ROOT)/boost\"",
        "OTHER_CPLUSPLUSFLAGS" => "-DFOLLY_NO_CONFIG -DFOLLY_MOBILE=1 -DFOLLY_USE_LIBCPP=1",
        "CLANG_CXX_LANGUAGE_STANDARD" => "c++17"
      }

      s.dependency 'React-Core'
      s.dependency "React-Codegen"
      s.dependency "React-RCTFabric"
      s.dependency "RCT-Folly"
      s.dependency "RCTRequired"
      s.dependency "RCTTypeSafety"
      s.dependency "ReactCommon/turbomodule/core"
    end
  else
    s.dependency 'React-Core'
  end
end
