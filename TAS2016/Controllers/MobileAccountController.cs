using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Claims;
using System.Diagnostics.Tracing;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.Extensions.Logging;
using TAS2016.Models;
using TAS2016.Models.AccountViewModels;
using TAS2016.Services;

namespace TAS2016.Controllers
{
    
    public class MobileAccountController : Controller
    {
        private readonly UserManager<ApplicationUser> _userManager;
        private readonly SignInManager<ApplicationUser> _signInManager;
        private readonly IEmailSender _emailSender;
        private readonly ISmsSender _smsSender;
        private readonly ILogger _logger;

        public MobileAccountController(
            UserManager<ApplicationUser> userManager,
            SignInManager<ApplicationUser> signInManager,
            IEmailSender emailSender,
            ISmsSender smsSender,
            ILoggerFactory loggerFactory)
        {
            _userManager = userManager;
            _signInManager = signInManager;
            _emailSender = emailSender;
            _smsSender = smsSender;
            _logger = loggerFactory.CreateLogger<AccountController>();
        }

        
     

        //
        // POST: /Account/Login
        [HttpPost]
        [AllowAnonymous]
        [Route("Mobile/Login")]

        public async Task<IActionResult> Login([FromBody]LoginViewModel model, string returnUrl = null)
        {
            ViewData["ReturnUrl"] = returnUrl;
            if (ModelState.IsValid)
            {
                // This doesn't count login failures towards account lockout
                // To enable password failures to trigger account lockout, set lockoutOnFailure: true
                var result = await _signInManager.PasswordSignInAsync(model.Email, model.Password, model.RememberMe, lockoutOnFailure: false);
                if (result.Succeeded)
                {
                    _logger.LogInformation(1, "User logged in.");
                    return Ok(new Message("Login success"));
                }
               
                
                else
                {
                    Console.WriteLine(model.Email);
                    Console.WriteLine(model.Password);
                    return BadRequest(new Message("Login failed"));

                }
            }

            // If we got this far, something failed, redisplay form
            
            return  BadRequest("Login failed");

        }




        //
        // POST: /Account/LogOff
        [HttpPost]
        
        [Route("Mobile/LogOff")]
        public async Task<IActionResult> LogOff()
        {
            await _signInManager.SignOutAsync();
            _logger.LogInformation(4, "User logged out.");
            return Ok("Logged out");
        }





    }
}
