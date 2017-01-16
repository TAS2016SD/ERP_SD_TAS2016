﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TAS2016.Models;
namespace TAS2016.Interfaces
{
    interface IClientRepository
    {
        IEnumerable<Client> ListAll();
        void Add(Client client);
        void Update(Client client);
        void Delete(Client client);
        Client get(int Id);
    }
}
