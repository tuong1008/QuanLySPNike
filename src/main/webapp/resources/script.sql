USE [QLSP]
GO
SET IDENTITY_INSERT [dbo].[Authorities] ON 

INSERT [dbo].[Authorities] ([authoritiesId], [authorityType], [username]) VALUES (CAST(1 AS Numeric(19, 0)), N'ROLE_ADMIN', N'admin')
SET IDENTITY_INSERT [dbo].[Authorities] OFF
SET IDENTITY_INSERT [dbo].[Customer] ON 

INSERT [dbo].[Customer] ([customerId], [customerEmailAddress], [customerName], [customerPhoneNumber], [enabled], [password], [username], [billingAddressId], [cartId], [shippingAddressId]) VALUES (CAST(1 AS Numeric(19, 0)), N'admin@gmail.com', N'admin', N'0123456789', 1, N'123', N'admin', NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Customer] OFF
