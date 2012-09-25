/*************************************************************************
 * Copyright 2009-2012 Eucalyptus Systems, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 * Please contact Eucalyptus Systems, Inc., 6755 Hollister Ave., Goleta
 * CA 93117, USA or visit http://www.eucalyptus.com/licenses/ if you need
 * additional information or have any questions.
 ************************************************************************/

(function($, eucalyptus) {
  // global variable
  if (! $.eucaData){
	$.eucaData = {};
  }
  var email = '';
 
  $(document).ready(function() {
    var initData = '';
    if (! isValidIp(location.hostname))
      initData = "action=init&host="+location.hostname;
    else
      initData = "action=init";
    $.when( // this is to synchronize a chain of ajax calls 
      $.ajax({
        type:"POST",
        data:initData,
        dataType:"json",
        async:"false", // async option deprecated as of jQuery 1.8
        success: function(out, textStatus, jqXHR){ 
          eucalyptus.i18n({'language':out.language});
          eucalyptus.help({'language':out.language}); // loads help files
          email = out.email;
          if(out.ipaddr && out.ipaddr.length>0 && isValidIp(out.ipaddr)){
            location.hostname = out.ipaddr;
          }
        },
        error: function(jqXHR, textStatus, errorThrown){
          //TODO: should present error screen; can we use notification?
          notifyError($.i18n.prop('server_unavailable'));
          logout();
        }
      })).done(function(out){
        // check cookie
        if ($.cookie('session-id')) {
          $.ajax({
  	    type:"POST",
	    data:"action=session&_xsrf="+$.cookie('_xsrf'),
	    dataType:"json",
	    async:"false",
	    success: function(out, textStatus, jqXHR){
	      $.extend($.eucaData, {'g_session':out.global_session, 'u_session':out.user_session});
              eucalyptus.main($.eucaData);
            },
	    error: function(jqXHR, textStatus, errorThrown){
              logout();
	    }
          });
        } else {
          var $main = $('html body').find('.euca-main-outercontainer .inner-container');
          $main.login({ 'email' : email, doLogin : function(evt, args) {
              var tok = args.param.account+':'+args.param.username+':'+args.param.password;
              var hash = btoa(tok);
              var remember = (args.param.remember!=null)?"yes":"no";
	      $.ajax({
	        type:"POST",
 	        data:"action=login&remember="+remember, 
                beforeSend: function (xhr) { 
                   xhr.setRequestHeader('Authorization', 'Basic '+hash); 
                   $main.find('#euca-main-container').append(
                     $('<div>').addClass('spin-wheel').append( 
                      $('<img>').attr('src','images/dots32.gif'))); // spinwheel
                   $main.find('#euca-main-container').show();
                },
    	        dataType:"json",
	        async:"false",
	        success: function(out, textStatus, jqXHR) {
	          $.extend($.eucaData, {'g_session':out.global_session, 'u_session':out.user_session});
                  args.onSuccess($.eucaData); // call back to login UI
                },
                error: function(jqXHR, textStatus, errorThrown){
                  var $container = $('html body').find(DOM_BINDING['main']);
                  $container.children().detach(); // remove spinwheel
	          args.onError(errorThrown);
                }
 	     });
         }});
       } // end of else
    }); // end of done
  }); // end of document.ready
})(jQuery,
   window.eucalyptus ? window.eucalyptus : window.eucalyptus = {});
