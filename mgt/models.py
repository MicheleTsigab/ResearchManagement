from django.db import models
from django.contrib.auth.models import User
class Staff(models.Model):
    id=models.AutoField(primary_key=True)
    first_name=models.CharField(max_length=150)
    last_name=models.CharField(max_length=150)
    phone=models.CharField(max_length=30,default="09000000",null=True)
    password=models.CharField(max_length=128)
    email=models.CharField(max_length=254)
    last_login=models.DateField()
    is_active=models.BooleanField()
    date_joined=models.DateField()
    roles=models.ManyToManyField('Role',through="StaffRole")
    class Meta:
        db_table = "staff"
class Role(models.Model):
    id=models.AutoField(primary_key=True)
    name=models.CharField(max_length=50)
    class Meta:
        db_table = "role"
class StaffRole(models.Model):
    staff=models.ForeignKey(Staff,on_delete=models.CASCADE)
    role=models.ForeignKey(Role,on_delete=models.CASCADE)
    date_issued=models.DateField()
    class Meta:
        db_table = "staff_role"

